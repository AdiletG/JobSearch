package kg.job.jobsearch.service;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.dto.update.UsersUpdateDto;
import kg.job.jobsearch.model.User;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    void updatePassword(User user, String newPassword);

    User findByToken(String token);

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

    void makeResetPasswordLink(HttpServletRequest request) throws MessagingException, UnsupportedEncodingException;
}
