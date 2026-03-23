package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.ResumeCreateDto;
import kg.job.jobsearch.dto.ResumeUpdateDto;
import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.exception.ContactsInfoNotFoundException;
import kg.job.jobsearch.exception.EducationNotFoundException;
import kg.job.jobsearch.exception.ResumeNotFoundException;
import kg.job.jobsearch.exception.WorkExperienceInfoNotFoundException;
import kg.job.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumeController {
    private final ResumeService resumeService;

    @GetMapping
    public List<ResumesDto> getAllResumes() throws ResumeNotFoundException {
        return resumeService.getAllResume();
    }

    @GetMapping("/search/by-category")
    public List<ResumesDto> getResumesByCategory(@RequestParam Integer category) throws ResumeNotFoundException {
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
            @PathVariable Long applicantId,
            @RequestBody ResumeCreateDto dto
            ) throws ResumeNotFoundException {
        resumeService.createResume(applicantId,dto);
    }

    @PatchMapping("/{resumeId}")
    public ResumesDto updateResume(
            @PathVariable Long resumeId,
            @RequestBody ResumeUpdateDto dto
            ) throws EducationNotFoundException, ResumeNotFoundException, WorkExperienceInfoNotFoundException, ContactsInfoNotFoundException {
        return resumeService.updateResume(resumeId, dto);
    }

    @DeleteMapping("/{resumeId}")
    public void deleteResume( @PathVariable Long resumeId) throws ResumeNotFoundException {
        resumeService.deleteResume(resumeId);
    }
}