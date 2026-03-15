package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;

    @GetMapping
    public ResponseEntity<List<ResumesDto>> getResumes(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer applicantId,
            @RequestParam(required = false) Boolean isActive
    ) {
        return ResponseEntity.ok(
                resumeService.searchResumes(categoryId, applicantId, isActive)
        );
    }

    @PostMapping
    public HttpStatus createResume(
            @RequestParam Integer userId,
            @RequestBody ResumesDto resumesDto
    ){
        resumeService.createResume(userId, resumesDto);
        return HttpStatus.OK;
    }

    @PutMapping("/{id}")
    public HttpStatus editResume(
            @RequestParam Integer userId,
            @PathVariable int id,
            @RequestBody ResumesDto resumesDto
    ){
        resumeService.editResume(userId, id, resumesDto);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteResume(
            @RequestParam Integer userId,
            @PathVariable int id
    ){
        resumeService.deleteResume(userId, id);
        return HttpStatus.OK;
    }

}