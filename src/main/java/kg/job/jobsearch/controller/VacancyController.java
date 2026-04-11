package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.exception.notFoundException.VacancyNotFoundException;
import kg.job.jobsearch.service.UserService;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;
    private final UserService userService;

    @GetMapping
    public String getAll(Model model) throws VacancyNotFoundException {
        model.addAttribute("currentPage", "vacancies");
        model.addAttribute("vacancies", vacancyService.getALLVacancies());
        return "vacancies/vacancies";
    }
}