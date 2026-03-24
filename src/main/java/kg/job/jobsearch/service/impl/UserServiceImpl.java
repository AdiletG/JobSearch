package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.UserDao;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public void createUser(UsersCreateDto dto) throws UserDataCreateException {
        try{
            User user = new User();
            user.setName(dto.getName());
            user.setSurname(dto.getSurname());
            user.setAge(dto.getAge());
            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setPhoneNumber(dto.getPhoneNumber());
            user.setAvatar(dto.getAvatar());
            user.setAccountType(dto.getAccountType());

            userDao.createUser(user);
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
    public UsersDto findById(int id) throws UserNotFoundException {
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
    public List<UsersDto> getApplicantByVacancies(int id) throws UserNotFoundException {
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