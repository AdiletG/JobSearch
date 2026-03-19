package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.UserDao;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.exception.UserNotFoundException;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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