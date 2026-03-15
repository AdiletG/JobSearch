package kg.job.jobsearch.controller;

import kg.job.jobsearch.service.FileService;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private UserService userService;
    private final FileService fileService;

    @PostMapping
    public ResponseEntity<String> uploadAvatar(@RequestParam MultipartFile file) {

        String filename = fileService.upload(file);

        return ResponseEntity.ok(filename);
    }
}