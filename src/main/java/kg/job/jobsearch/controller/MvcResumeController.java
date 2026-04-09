package kg.job.jobsearch.controller;

import kg.job.jobsearch.exception.notFoundException.ResumeNotFoundException;
import kg.job.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class MvcResumeController {
    private final ResumeService resumeService;

    @GetMapping
    public String getAllResumes(Model model) throws ResumeNotFoundException {
        model.addAttribute("resumes", resumeService.getAllResume());
        return "resumes/resumes";
    }
}