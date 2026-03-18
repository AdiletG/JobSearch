package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.UserDao;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.exception.UserNotFoundException;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public List<UsersDto> getAllUsers() throws UserNotFoundException {
        List<User> users = userDao.getAllUser();
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        List<UsersDto> result = new ArrayList<>();

        users.forEach( a -> {
            UsersDto user = UsersDto.builder()
                    .id(a.getId())
                    .name(a.getName())
                    .surname(a.getSurname())
                    .age(a.getAge())
                    .email(a.getEmail())
                    .password(a.getPassword())
                    .phone_number(a.getPhone_number())
                    .avatar(a.getAvatar())
                    .account_type(a.getAccount_type())
                    .build();
            result.add(user);
        });

        return result;
    }

    @Override
    public UsersDto findById(int id) throws UserNotFoundException {
          User user = userDao.findById(id)
                  .orElseThrow(UserNotFoundException::new);
        return UsersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .phone_number(user.getPhone_number())
                .avatar(user.getAvatar())
                .account_type(user.getAccount_type())
                .build();
    }

    @Override
    public UsersDto findByEmail(String email) throws UserNotFoundException {
        User user = userDao.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return UsersDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .phone_number(user.getPhone_number())
                .avatar(user.getAvatar())
                .account_type(user.getAccount_type())
                .build();
    }

    @Override
    public List<UsersDto> findByName(String name) throws UserNotFoundException {
        List<User> users = userDao.findByName(name);
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return users.stream()
                .map(user -> UsersDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .surname(user.getSurname())
                        .age(user.getAge())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .phone_number(user.getPhone_number())
                        .avatar(user.getAvatar())
                        .account_type(user.getAccount_type())
                        .build())
                .toList();
    }

    @Override
    public List<UsersDto> findByPhoneNumber(String number) throws UserNotFoundException {
        List<User> users = userDao.findByPhoneNumber(number);
        if(users.isEmpty()){
            throw new UserNotFoundException();
        }
        return users.stream()
                .map(user -> UsersDto.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .surname(user.getSurname())
                        .age(user.getAge())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .phone_number(user.getPhone_number())
                        .avatar(user.getAvatar())
                        .account_type(user.getAccount_type())
                        .build())
                .toList();
    }

    @Override
    public String existsUserByEmail(String email) throws UserNotFoundException {
        String result = "Пользователь существует";

        if(!userDao.existsUserByEmail(email)){
           result = "Пользователь не существует";
           throw new UserNotFoundException();
        }

        return result;
    }

}