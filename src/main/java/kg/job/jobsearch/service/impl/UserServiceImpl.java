package kg.job.jobsearch.service.impl;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import kg.job.jobsearch.common.UrlBuilder;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.dto.update.UsersUpdateDto;
import kg.job.jobsearch.enums.AccountTypeEnums;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.exception.notFoundException.UserNameNotFoundException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.exception.updateException.UserDataUpdateException;
import kg.job.jobsearch.model.Authority;
import kg.job.jobsearch.model.Role;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.repository.RoleRepository;
import kg.job.jobsearch.repository.UserRepository;
import kg.job.jobsearch.service.EmailService;
import kg.job.jobsearch.service.FileService;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final FileService fileService;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final RoleRepository roleRepository;

    @Override
    public void makeResetPasswordLink(HttpServletRequest request)
            throws UserNotFoundException, MessagingException, UnsupportedEncodingException {
        String email = request.getParameter("email");
        String token = UUID.randomUUID().toString();
        updateResetPasswordToken(token, email);

        String resetPwdLink = UrlBuilder.getSiteUrl(request) + "/auth/reset-password?token=" + token;
        emailService.send(email, resetPwdLink);
    }

    @Override
    public void updatePassword(User user, String newPassword){
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        user.setResetPasswordToken(null);
        userRepository.saveAndFlush(user);
    }

    @Override
    public User findByToken(String token){
        return userRepository.findByResetPasswordToken(token)
                .orElseThrow(UserNotFoundException::new);
    }

    private void updateResetPasswordToken(String token, String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        user.setResetPasswordToken(token);
        userRepository.saveAndFlush(user);
    }

        @Override
        public UsersUpdateDto getUserForUpdate(String email) {
            User user = userRepository.findByEmail(email)
                    .orElseThrow(UserNotFoundException::new);

            return UsersUpdateDto.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .surname(user.getSurname())
                    .age(user.getAge())
                    .email(user.getEmail())
                    .phoneNumber(user.getPhoneNumber())
                    .avatarPath(user.getAvatar())
                    .build();
        }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId)
                    .orElseThrow(UserNotFoundException::new);

        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(Long userId, UsersUpdateDto dto){
        try{
            User user = userRepository.findById(userId)
                    .orElseThrow(UserNotFoundException::new);

            if (dto.getName() != null) {
                user.setName(dto.getName());
            }

            if (dto.getSurname() != null) {
                user.setSurname(dto.getSurname());
            }

            if (dto.getAge() != null) {
                user.setAge(dto.getAge());
            }

            if (dto.getEmail() != null) {
                user.setEmail(dto.getEmail());
            }

            if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
                if (!dto.getPassword().equals(dto.getPasswordConfirm())) {
                    throw new UserDataUpdateException();
                }
                user.setPassword(passwordEncoder.encode(dto.getPassword()));
            }

            if (dto.getPhoneNumber() != null) {
                user.setPhoneNumber(dto.getPhoneNumber());
            }

            String avatarFilename = null;

            if (dto.getAvatar() != null && !dto.getAvatar().isEmpty()) {
                avatarFilename = fileService.saveAvatar(dto.getAvatar());
                user.setAvatar(avatarFilename);
            }

            if (avatarFilename != null) {
                fileService.upload(userId, avatarFilename);
            }

            userRepository.save(user);

        }catch (UserNotFoundException e){
            e.printStackTrace();
            throw new UserDataUpdateException();
        }
    }

    @Override
    @Transactional
    public void createUser(UsersCreateDto form) {
        try {
            User dto = new User();
            dto.setName(form.getName());
            dto.setSurname(form.getSurname());
            dto.setAge(form.getAge());
            dto.setEmail(form.getEmail());
            dto.setPassword(passwordEncoder.encode(form.getPassword()));
            dto.setPhoneNumber(form.getPhoneNumber());
            dto.setAccountType(form.getAccountType());
            String roleName = form.getAccountType() == AccountTypeEnums.APPLICANT
                    ? "ROLE_APPLICANT"
                    : "ROLE_EMPLOYER";
            Role role = roleRepository.findRoleByRoleName(roleName)
                            .orElseThrow(RoleNotFoundException::new);
            dto.setRoles(List.of(role));

            String avatarFilename = null;

            if (form.getAvatar() != null && !form.getAvatar().isEmpty()) {
                avatarFilename = fileService.saveAvatar(form.getAvatar());
                dto.setAvatar(avatarFilename);
            }

            Long userId = userRepository.save(dto).getId();

            if (avatarFilename != null) {
                fileService.upload(userId, avatarFilename);
            }

        }catch (Exception e){
            throw new UserDataCreateException();
        }
    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return users.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public UsersDto findById(Long id) {
          User user = userRepository.findById(id)
                  .orElseThrow(UserNotFoundException::new);
        return mapToDto(user);
    }

    @Override
    public UsersDto findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return mapToDto(user);
    }

    @Override
    public List<UsersDto> findByName(String name) {
        List<User> users = userRepository.findByName(name);

        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return  users.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<UsersDto> findByPhoneNumber(String number) {
        List<User> users = userRepository.findByPhoneNumber(number);
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return users.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<UsersDto> getApplicantByVacancies(Long id) {
        List<User> users = userRepository.findApplicantsByVacancyId(id);

        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return users.stream()
                .map(this::mapToDto)
                .toList();
    }

    private UsersDto mapToDto(User user) {
        return UsersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .avatar(user.getAvatar())
                .accountType(user.getAccountType())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findByEmail(username)
                    .orElseThrow(UserNameNotFoundException::new);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles){
            return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges){
            List<GrantedAuthority> authorities = new ArrayList<>();
            for(String privilege : privileges){
                authorities.add(new SimpleGrantedAuthority(privilege));
            }

            return authorities;
    }

    private List<String> getPrivileges(Collection<Role> roles){
            List<String> privileges = new ArrayList<>();
            List<Authority> collection = new ArrayList<>();

            for(Role role : roles){
                privileges.add(role.getRoleName());
                collection.addAll(role.getAuthorities());
            }

            for(Authority item : collection){
                privileges.add(item.getAuthorityName());
            }

            return privileges;
    }
}