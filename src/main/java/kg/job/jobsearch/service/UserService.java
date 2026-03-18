package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<UsersDto> getAllUsers();


    UsersDto findById(int id) throws UserNotFoundException;
}
