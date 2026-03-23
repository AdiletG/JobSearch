package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.*;
import kg.job.jobsearch.exception.*;
import kg.job.jobsearch.model.Vacancy;
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

    @GetMapping("/search/by-applicant")
    public List<VacanciesDto> getVacanciesByApplicant(@RequestParam Integer id) throws VacancyNotFoundException {
        return vacancyService.getVacanciesByApplicant(id);
    }

    @PostMapping("/{authorId}")
    public void createVacancy(
            @PathVariable Long authorId,
            @RequestBody VacanciesCreateDto dto){
        vacancyService.createVacancy(authorId, dto);
    }

    @PatchMapping("/{vacancyId}")
    public VacanciesDto update(
            @PathVariable Long vacancyId,
            @RequestBody VacanciesUpdateDto dto
    ) throws VacancyNotFoundException {
        return vacancyService.update(vacancyId, dto);
    }

    @DeleteMapping("/{vacancyId}")
    public void deleteResume( @PathVariable Long vacancyId) throws VacancyNotFoundException {
        vacancyService.delete(vacancyId);
    }

}