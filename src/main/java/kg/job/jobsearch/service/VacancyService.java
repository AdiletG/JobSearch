package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.exception.VacancyNotFoundException;

import java.util.List;

public interface VacancyService {

    List<VacanciesDto> getALLVacancies() throws VacancyNotFoundException;

    List<VacanciesDto> getVacancyByCategory(int category) throws VacancyNotFoundException;

    List<VacanciesDto> getVacancyByActive(boolean active) throws VacancyNotFoundException;

    List<VacanciesDto> getVacanciesByApplicant(int id) throws VacancyNotFoundException;

    void createVacancy(VacanciesDto vacanciesDto);
}
