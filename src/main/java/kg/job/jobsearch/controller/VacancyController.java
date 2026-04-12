package kg.job.jobsearch.controller;

import jakarta.validation.Valid;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.VacanciesCreateDto;
import kg.job.jobsearch.dto.update.VacanciesUpdateDto;
import kg.job.jobsearch.exception.createException.VacancyDataCreateException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.exception.notFoundException.VacancyNotFoundException;
import kg.job.jobsearch.service.UserService;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

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

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("vacancy", new VacanciesCreateDto());
        return "vacancies/vacancy-create";
    }

    @GetMapping("/update")
    public String update(Model model){
        model.addAttribute("vacancy", new VacanciesUpdateDto());
        return "vacancies/vacancy-update";
    }


    @PostMapping("/create")
    public String createPost(
            @Valid @ModelAttribute("vacancy") VacanciesCreateDto dto,
            BindingResult bindingResult, Principal principal, Model model)
            throws UserNotFoundException, VacancyDataCreateException {
        UsersDto user = userService.findByEmail(principal.getName());
        if(!bindingResult.hasErrors()){
            vacancyService.createVacancy(user.getId(), dto);
            return "redirect:/profile";
        }

        model.addAttribute("vacancy", new VacanciesCreateDto());
        return "vacancies/vacancy-create";
    }
}