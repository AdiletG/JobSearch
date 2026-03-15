package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.CategoriesDto;
import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.service.CategoriesService;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacanciesController {
    private final VacancyService vacancyService;

    @GetMapping
    public ResponseEntity<List<VacanciesDto>> getVacancies(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer authorId,
            @RequestParam(required = false) Boolean isActive
    ){
        return ResponseEntity.ok(
                vacancyService.searchVacancies(categoryId, authorId, isActive)
        );
    }

    @PostMapping
    public HttpStatus createVacancies(@RequestBody VacanciesDto vacanciesDto){vacancyService.createVacancy(vacanciesDto);return HttpStatus.OK;}

    @PutMapping("/{id}")
    public HttpStatus editVacancies(@PathVariable int id, @RequestBody VacanciesDto vacanciesDto)
    {vacancyService.editVacancy(id, vacanciesDto);return HttpStatus.OK;}

    @DeleteMapping("/{id}")
    public HttpStatus deleteVacancies(@PathVariable int id){vacancyService.deleteVacancy(id);return HttpStatus.OK;}

}