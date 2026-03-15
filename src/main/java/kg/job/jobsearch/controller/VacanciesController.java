package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.VacanciesDto;
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
    public HttpStatus createVacancies(
            @RequestParam Integer userId,
            @RequestBody VacanciesDto vacanciesDto
    ){
        vacancyService.createVacancy(userId, vacanciesDto);
        return HttpStatus.OK;}

    @PutMapping("/{id}")
    public HttpStatus editVacancies(
            @RequestParam Integer userId,
            @PathVariable Integer id,
            @RequestBody VacanciesDto vacanciesDto)
    {vacancyService.editVacancy(userId, id, vacanciesDto);return HttpStatus.OK;}

    @DeleteMapping("/{id}")
    public HttpStatus deleteVacancies(
            @RequestParam Integer userId,
            @PathVariable Integer id
    ){vacancyService.deleteVacancy(userId, id);return HttpStatus.OK;}

}