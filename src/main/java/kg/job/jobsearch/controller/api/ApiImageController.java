package kg.job.jobsearch.controller.api;

import kg.job.jobsearch.dto.UserImageDto;
import kg.job.jobsearch.exception.notFoundException.UserImageNotFoundException;
import kg.job.jobsearch.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ApiImageController {
    private final FileService fileService;

    @PostMapping
    public HttpStatus upload(UserImageDto dto){
         fileService.upload(dto);
        return HttpStatus.OK;
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> download(@PathVariable Long userId) throws UserImageNotFoundException {
        return fileService.download(userId);
    }
}