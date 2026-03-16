package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.UsersDto;

import java.util.List;

public interface UserService {
    List<UsersDto> getAllUsers();

    UsersDto getUserById(Integer id);

    List<UsersDto> searchUsersByAccountType(Integer userId, String name);
}
