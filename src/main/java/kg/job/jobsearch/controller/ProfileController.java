package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.enums.AccountTypeEnums;
import kg.job.jobsearch.exception.notFoundException.ResumeNotFoundException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.exception.notFoundException.VacancyNotFoundException;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.service.RespondedApplicantService;
import kg.job.jobsearch.service.ResumeService;
import kg.job.jobsearch.service.UserService;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UserService userService;
    private final ResumeService resumeService;
    private final VacancyService vacancyService;
    private final RespondedApplicantService respondedApplicantService;

    @GetMapping
    public String getProfile(Model model, Principal principal) throws VacancyNotFoundException, UserNotFoundException, ResumeNotFoundException {

        model.addAttribute("currentPage", "profile");

        UsersDto user = userService.findByEmail(principal.getName());

        if (user.getAccountType() == AccountTypeEnums.APPLICANT) {
            model.addAttribute("resumes", resumeService.getResumeByApplicant(user.getId()));
        } else if (user.getAccountType() == AccountTypeEnums.EMPLOYER) {
            model.addAttribute("vacancies", vacancyService.getALLVacanciesByAuthor(user.getId()));
        }
        return "users/profile";
    }
}