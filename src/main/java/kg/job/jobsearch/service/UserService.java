package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.dto.update.UsersUpdateDto;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.exception.updateException.UserDataUpdateException;

import java.util.List;

public interface UserService {
    void deleteUser(Long userId) throws UserNotFoundException;

    void updateUser(Long userId, UsersUpdateDto dto) throws UserDataUpdateException;


    void createUser(UsersCreateDto form) throws UserDataCreateException;

    List<UsersDto> getAllUsers() throws UserNotFoundException;

    UsersDto findById(Long id) throws UserNotFoundException;

    UsersDto findByEmail(String email) throws UserNotFoundException;

    List<UsersDto> findByName(String name) throws UserNotFoundException;

    List<UsersDto> findByPhoneNumber(String number) throws UserNotFoundException;

    boolean existsUserByEmail(String email) throws UserNotFoundException;

    List<UsersDto> getApplicantByVacancies(Long id) throws UserNotFoundException;
}
