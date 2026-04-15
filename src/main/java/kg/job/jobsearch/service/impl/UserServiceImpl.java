package kg.job.jobsearch.service.impl;

import jakarta.transaction.Transactional;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.dto.update.UsersUpdateDto;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.exception.updateException.UserDataUpdateException;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.repository.UserRepository;
import kg.job.jobsearch.service.FileService;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FileService fileService;
    private final PasswordEncoder passwordEncoder;

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
        try{
            User dto = new User();
            dto.setName(form.getName());
            dto.setSurname(form.getSurname());
            dto.setAge(form.getAge());
            dto.setEmail(form.getEmail());
            dto.setPassword(passwordEncoder.encode(form.getPassword()));
            dto.setPhoneNumber(form.getPhoneNumber());
            dto.setAccountType(form.getAccountType());

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
}