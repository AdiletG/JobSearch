package kg.job.jobsearch.controller;

import jakarta.validation.Valid;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.update.UsersUpdateDto;
import kg.job.jobsearch.enums.AccountTypeEnums;
import kg.job.jobsearch.exception.notFoundException.ResumeNotFoundException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.exception.notFoundException.VacancyNotFoundException;
import kg.job.jobsearch.exception.updateException.UserDataUpdateException;
import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.model.Vacancy;
import kg.job.jobsearch.service.RespondedApplicantService;
import kg.job.jobsearch.service.ResumeService;
import kg.job.jobsearch.service.UserService;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UserService userService;
    private final ResumeService resumeService;
    private final VacancyService vacancyService;
    private final RespondedApplicantService respondedApplicantService;

    @GetMapping
    public String getProfile(
            Model model,
            Principal principal,
            @PageableDefault(size = 3) Pageable pageable)
            throws VacancyNotFoundException, UserNotFoundException, ResumeNotFoundException {

        model.addAttribute("currentPage", "profile");

        UsersDto user = userService.findByEmail(principal.getName());

        if (user.getAccountType() == AccountTypeEnums.APPLICANT) {
            try {
                Page<Resume> page;
                page = resumeService.findByApplicantFromPage(user.getId(), pageable);
                model.addAttribute("page", page);
                model.addAttribute("resumes", page.getContent());
            } catch (ResumeNotFoundException e) {
                model.addAttribute("resumes", List.of());
            }
        } else if (user.getAccountType() == AccountTypeEnums.EMPLOYER) {
            try {
                Page<Vacancy> page;
                page = vacancyService.findByAuthorId(user.getId(), pageable);
                model.addAttribute("page", page);
                model.addAttribute("vacancies", page.getContent());
            } catch (VacancyNotFoundException e) {
                model.addAttribute("vacancies", List.of());
            }
        }
        return "users/profile";
    }

    @GetMapping("/update")
    public String getProfileUpdate(Principal principal, Model model) throws UserNotFoundException {
        UsersUpdateDto user = userService.getUserForUpdate(principal.getName());
        model.addAttribute("userDto", user);
        return "users/profile-update";
    }

    @PostMapping("/update")
    public String updatePost(
            @Valid @ModelAttribute("userDto") UsersUpdateDto dto,
            BindingResult bindingResult,
            Principal principal, Model model) throws UserDataUpdateException, UserNotFoundException {

        if (!bindingResult.hasErrors()) {
            UsersDto currentUser = userService.findByEmail(principal.getName());
            userService.updateUser(currentUser.getId(), dto);
            return "redirect:/profile";
        }

        model.addAttribute("user", dto);
        return "users/profile-update";
    }

}