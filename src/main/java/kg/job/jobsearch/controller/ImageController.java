package kg.job.jobsearch.controller;

import kg.job.jobsearch.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {
    private final FileService fileService;

    @PostMapping
    public HttpStatus upload(MultipartFile file){
         fileService.upload(file);
        return HttpStatus.OK;
    }
}