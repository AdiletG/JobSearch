package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.VacanciesDto;

import java.util.List;

public interface VacancyService {

    List<VacanciesDto> getALLVacancies();
}
