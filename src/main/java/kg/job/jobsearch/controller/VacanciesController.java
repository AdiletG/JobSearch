package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.exception.VacancyNotFoundException;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacanciesController {
    private final VacancyService vacancyService;


    @GetMapping
    public List<VacanciesDto> getAllVacancies() throws VacancyNotFoundException {
        return vacancyService.getALLVacancies();
    }

    @GetMapping("/search/by-category")
    public List<VacanciesDto> getVacanciesByCategory(@RequestParam Integer category) throws VacancyNotFoundException {
        return vacancyService.getVacancyByCategory(category);
    }

    @GetMapping("/search/by-active")
    public List<VacanciesDto> getVacanciesByActive(@RequestParam Boolean active) throws VacancyNotFoundException {
        return vacancyService.getVacancyByActive(active);
    }

}