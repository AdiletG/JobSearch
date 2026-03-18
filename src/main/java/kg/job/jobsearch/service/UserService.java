package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<UsersDto> getAllUsers() throws UserNotFoundException;


    UsersDto findById(int id) throws UserNotFoundException;

    UsersDto findByEmail(String email) throws UserNotFoundException;

    List<UsersDto> findByName(String name) throws UserNotFoundException;

    List<UsersDto> findByPhoneNumber(String number) throws UserNotFoundException;

    String existsUserByEmail(String email) throws UserNotFoundException;
}
