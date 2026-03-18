package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.exception.UserNotFoundException;
import kg.job.jobsearch.service.FileService;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public String existsUserByEmail(@RequestParam String email) throws UserNotFoundException{
        return userService.existsUserByEmail(email);
    }

    @PostMapping
    public ResponseEntity<String> uploadAvatar(@RequestParam MultipartFile file) {
        String filename = fileService.upload(file);
        return ResponseEntity.ok(filename);
    }
}