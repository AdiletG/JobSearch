package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.*;
import kg.job.jobsearch.dto.create.VacanciesCreateDto;
import kg.job.jobsearch.dto.update.VacanciesUpdateDto;
import kg.job.jobsearch.exception.createException.VacancyDataCreateException;
import kg.job.jobsearch.exception.notFoundException.VacancyNotFoundException;
import kg.job.jobsearch.exception.updateException.VacancyDataUpdateException;
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
    public List<VacanciesDto> getVacanciesByCategory(@RequestParam Long category) throws VacancyNotFoundException {
        return vacancyService.getVacancyByCategory(category);
    }

    @GetMapping("/search/by-active")
    public List<VacanciesDto> getVacanciesByActive(@RequestParam Boolean active) throws VacancyNotFoundException {
        return vacancyService.getVacancyByActive(active);
    }

    @GetMapping("/search/by-applicant")
    public List<VacanciesDto> getVacanciesByApplicant(@RequestParam Long id) throws VacancyNotFoundException {
        return vacancyService.getVacanciesByApplicant(id);
    }

    @PostMapping("/{authorId}")
    public void createVacancy(
            @PathVariable Long authorId,
            @RequestBody VacanciesCreateDto dto) throws VacancyDataCreateException {
        vacancyService.createVacancy(authorId, dto);
    }

    @PatchMapping("/{vacancyId}")
    public VacanciesDto update(
            @PathVariable Long vacancyId,
            @RequestBody VacanciesUpdateDto dto
    ) throws VacancyDataUpdateException, VacancyNotFoundException {
        return vacancyService.update(vacancyId, dto);
    }

    @DeleteMapping("/{vacancyId}")
    public void deleteResume( @PathVariable Long vacancyId) throws VacancyNotFoundException {
        vacancyService.delete(vacancyId);
    }

}