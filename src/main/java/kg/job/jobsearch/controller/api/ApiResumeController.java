package kg.job.jobsearch.controller.api;

import jakarta.validation.Valid;
import kg.job.jobsearch.dto.create.ResumeCreateDto;
import kg.job.jobsearch.dto.update.ResumeUpdateDto;
import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.exception.createException.ResumeDataCreateException;
import kg.job.jobsearch.exception.notFoundException.*;
import kg.job.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/resumes")
@RequiredArgsConstructor
public class ApiResumeController {
    private final ResumeService resumeService;

    @GetMapping
    public List<ResumesDto> getAllResumes() throws ResumeNotFoundException {
        return resumeService.getAllResume();
    }

    @GetMapping("/search/by-category")
    public List<ResumesDto> getResumesByCategory(@RequestParam Long category) throws ResumeNotFoundException {
        return resumeService.getResumeByCategory(category);
    }

    @GetMapping("/search/by-applicant")
    public List<ResumesDto> getResumesByApplicant(@RequestParam Long applicant) throws ResumeNotFoundException {
        return resumeService.getResumeByApplicant(applicant);
    }

    @GetMapping("/search/by-active")
    public List<ResumesDto> getResumesByActive(@RequestParam Boolean active) throws ResumeNotFoundException {
        return resumeService.getResumeByActive(active);
    }

    @PostMapping("/{applicantId}")
    public void createResume(
            @Valid
            @PathVariable Long applicantId,
            @RequestBody ResumeCreateDto dto
            ) throws ResumeNotFoundException, ResumeDataCreateException {
        resumeService.createResume(applicantId,dto);
    }

    @PatchMapping("/{resumeId}")
    public ResumesDto updateResume(
            @PathVariable Long resumeId,
            @RequestBody ResumeUpdateDto dto
            ) throws EducationNotFoundException, ResumeNotFoundException, WorkExperienceInfoNotFoundException, ContactsInfoNotFoundException, CategoryNotFoundException {
        return resumeService.updateResume(resumeId, dto);
    }

    @DeleteMapping("/{resumeId}")
    public void deleteResume( @PathVariable Long resumeId) throws ResumeNotFoundException {
        resumeService.deleteResume(resumeId);
    }
}