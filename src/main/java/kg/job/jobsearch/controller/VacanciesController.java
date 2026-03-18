package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.VacanciesDto;
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
    public List<VacanciesDto> getAllVacancies(){
        return vacancyService.getALLVacancies();
    }

}