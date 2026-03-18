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
    public List<UsersDto> getAllUsers(){
        List<User> users = userDao.getAllUser();

        List<UsersDto> result = new ArrayList<>();

        users.forEach( a -> {
            UsersDto user = UsersDto.builder()
                    .id(a.getId())
                    .name(a.getName())
                    .password(a.getPassword())
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
                .password(user.getPassword())
                .build();
    }

}