package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;

import java.util.List;

public interface UserService {
    void createUser(UsersCreateDto dto) throws UserDataCreateException;

    List<UsersDto> getAllUsers() throws UserNotFoundException;


    UsersDto findById(int id) throws UserNotFoundException;

    UsersDto findByEmail(String email) throws UserNotFoundException;

    List<UsersDto> findByName(String name) throws UserNotFoundException;

    List<UsersDto> findByPhoneNumber(String number) throws UserNotFoundException;

    boolean existsUserByEmail(String email) throws UserNotFoundException;

    List<UsersDto> getApplicantByVacancies(int id) throws UserNotFoundException;
}
