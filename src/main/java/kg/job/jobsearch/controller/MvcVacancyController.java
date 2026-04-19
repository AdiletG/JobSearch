package kg.job.jobsearch.controller;

import jakarta.validation.Valid;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.create.VacanciesCreateDto;
import kg.job.jobsearch.dto.update.VacanciesUpdateDto;
import kg.job.jobsearch.exception.createException.VacancyDataCreateException;
import kg.job.jobsearch.exception.notFoundException.CategoryNotFoundException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.exception.notFoundException.VacancyNotFoundException;
import kg.job.jobsearch.exception.updateException.VacancyDataUpdateException;
import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.model.Vacancy;
import kg.job.jobsearch.service.UserService;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class MvcVacancyController {
    private final VacancyService vacancyService;
    private final UserService userService;

    @GetMapping
    public String getAllVacancies(
            @RequestParam(required = false) String sort,
            Model model,
            @PageableDefault(size = 5, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        Page<Vacancy> page;
        if ("responsesCount,desc".equals(sort)) {
            Pageable pageWithoutSort = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
            page = vacancyService.findAllOrderByResponsesCountDesc(pageWithoutSort);
        } else {
            page = vacancyService.getVacancyByPage(pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("vacancies", page.getContent());
        model.addAttribute("sort", sort);
        model.addAttribute("currentPage", "vacancies");
        return "vacancies/vacancies";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("vacancy", new VacanciesCreateDto());
        return "vacancies/vacancy-create";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) throws VacancyNotFoundException {
        VacanciesUpdateDto vacancy = vacancyService.getByIdForUpdate(id);
        model.addAttribute("vacancy", vacancy);
        return "vacancies/vacancy-update";
    }

    @PostMapping("/create")
    public String createPost(
            @Valid @ModelAttribute("vacancy") VacanciesCreateDto dto,
            BindingResult bindingResult, Principal principal, Model model)
            throws UserNotFoundException, VacancyDataCreateException {
        UsersDto user = userService.findByEmail(principal.getName());

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> System.out.println("❌ ERROR: " + e));
            return "vacancies/vacancy-create";
        }

        if(!bindingResult.hasErrors()){
            vacancyService.createVacancy(user.getId(), dto);
            return "redirect:/profile";
        }

        model.addAttribute("vacancy", new VacanciesCreateDto());
        return "vacancies/vacancy-create";
    }

    @PostMapping("/update/{id}")
    public String updatePost(
            @Valid @ModelAttribute("vacancy") VacanciesUpdateDto dto,
            @PathVariable Long id, BindingResult bindingResult, Model model)
            throws VacancyDataUpdateException, VacancyNotFoundException, CategoryNotFoundException {
        if(!bindingResult.hasErrors()){
            vacancyService.update(id, dto);
            return "redirect:/profile";
        }

        model.addAttribute("vacancy", dto);
        return "vacancies/vacancy-update";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(
            @PathVariable Long id, Model model) throws VacancyNotFoundException {
        vacancyService.delete(id);
        return "redirect:/profile";
    }
}