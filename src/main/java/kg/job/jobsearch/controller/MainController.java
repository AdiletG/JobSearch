package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.service.ResumeService;
import kg.job.jobsearch.service.UserService;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;

    @GetMapping
    public String index(Model model) throws UserNotFoundException {
        model.addAttribute("currentPage", "home");
        return "index";
    }
}