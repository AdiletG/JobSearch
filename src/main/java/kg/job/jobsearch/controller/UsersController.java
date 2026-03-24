package kg.job.jobsearch.controller;

import jakarta.validation.Valid;
import kg.job.jobsearch.dto.UserImageDto;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.service.FileService;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;
    private final FileService fileService;

    @GetMapping
    public List<UsersDto> getAllUsers() throws UserNotFoundException {
        return userService.getAllUsers();
    }

    @GetMapping("/search/by-id")
    public UsersDto findById(@RequestParam Integer id) throws UserNotFoundException{
        return userService.findById(id);
    }

    @GetMapping("/search/by-email")
    public UsersDto findByEmail(@RequestParam String email) throws UserNotFoundException{
        return userService.findByEmail(email);
    }

    @GetMapping("/search/by-name")
    public List<UsersDto> findByName(@RequestParam String name) throws UserNotFoundException{
        return userService.findByName(name);
    }

    @GetMapping("/search/by-phone")
    public List<UsersDto> findByPhoneNumber(@RequestParam String phone) throws UserNotFoundException{
        return userService.findByPhoneNumber(phone);
    }

    @GetMapping("/search/user-exists")
    public boolean existsUserByEmail(@RequestParam String email) throws UserNotFoundException{
        return userService.existsUserByEmail(email);
    }

    @GetMapping("/search/user-vacancies")
    public List<UsersDto> getApplicantByVacancies(@RequestParam Integer id) throws UserNotFoundException{
        return userService.getApplicantByVacancies(id);
    }

    @PostMapping()
    public void createUsers(@Valid @RequestBody UsersCreateDto user) throws UserDataCreateException {
        userService.createUser(user);
    }
}