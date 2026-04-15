package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.dto.update.UsersUpdateDto;

import java.util.List;

public interface UserService {
    UsersUpdateDto getUserForUpdate(String email);

    void deleteUser(Long userId);

    void updateUser(Long userId, UsersUpdateDto dto);


    void createUser(UsersCreateDto form);

    List<UsersDto> getAllUsers();

    UsersDto findById(Long id);

    UsersDto findByEmail(String email);

    List<UsersDto> findByName(String name);

    List<UsersDto> findByPhoneNumber(String number);

    boolean existsUserByEmail(String email);

    List<UsersDto> getApplicantByVacancies(Long id);
}
