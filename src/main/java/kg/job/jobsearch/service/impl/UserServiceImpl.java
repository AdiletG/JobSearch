package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.UserDao;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.dto.update.UsersUpdateDto;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.exception.updateException.UserDataUpdateException;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.service.FileService;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final FileService fileService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void deleteUser(Long userId) throws UserNotFoundException {
        userDao.findById(userId)
                    .orElseThrow(UserNotFoundException::new);

        userDao.deleteUser(userId);
    }

    @Override
    public void updateUser(Long userId, UsersUpdateDto dto) throws UserDataUpdateException{
        try{
            User user = userDao.findById(userId)
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

            if (dto.getPassword() != null) {
                user.setPassword(dto.getPassword());
            }

            if (dto.getPhoneNumber() != null) {
                user.setPhoneNumber(dto.getPhoneNumber());
            }

            if (dto.getAvatar() != null) {
                user.setAvatar(dto.getAvatar());
            }

            userDao.updateUser(userId, user);
        }catch (SQLException | UserNotFoundException e){
            throw new UserDataUpdateException();
        }
    }

    @Override
    public void createUser(UsersCreateDto form) throws UserDataCreateException {
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

            Long userId = userDao.createUser(dto);

            if (avatarFilename != null) {
                fileService.upload(userId, avatarFilename);
            }

        }catch (SQLException e){
            throw new UserDataCreateException();
        }
    }

    @Override
    public List<UsersDto> getAllUsers() throws UserNotFoundException {
        List<User> users = userDao.getAllUser();
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return users.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public UsersDto findById(Long id) throws UserNotFoundException {
          User user = userDao.findById(id)
                  .orElseThrow(UserNotFoundException::new);
        return mapToDto(user);
    }

    @Override
    public UsersDto findByEmail(String email) throws UserNotFoundException {
        User user = userDao.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return mapToDto(user);
    }

    @Override
    public List<UsersDto> findByName(String name) throws UserNotFoundException {
        List<User> users = userDao.findByName(name);
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return  users.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<UsersDto> findByPhoneNumber(String number) throws UserNotFoundException {
        List<User> users = userDao.findByPhoneNumber(number);
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return users.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userDao.existsUserByEmail(email);
    }

    @Override
    public List<UsersDto> getApplicantByVacancies(Long id) throws UserNotFoundException {
        List<User> users = userDao.getApplicantByVacancies(id);

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