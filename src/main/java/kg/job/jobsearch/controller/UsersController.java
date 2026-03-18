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
    public List<UsersDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UsersDto findById(@PathVariable int id) throws UserNotFoundException{
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> uploadAvatar(@RequestParam MultipartFile file) {
        String filename = fileService.upload(file);
        return ResponseEntity.ok(filename);
    }
}