package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.create.VacanciesCreateDto;
import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.dto.update.VacanciesUpdateDto;
import kg.job.jobsearch.exception.createException.VacancyDataCreateException;
import kg.job.jobsearch.exception.notFoundException.VacancyNotFoundException;
import kg.job.jobsearch.exception.updateException.VacancyDataUpdateException;

import java.util.List;

public interface VacancyService {

    List<VacanciesDto> getALLVacancies() throws VacancyNotFoundException;

    List<VacanciesDto> getVacancyByCategory(Long category) throws VacancyNotFoundException;

    List<VacanciesDto> getVacancyByActive(boolean active) throws VacancyNotFoundException;

    List<VacanciesDto> getVacanciesByApplicant(Long id) throws VacancyNotFoundException;

    void createVacancy(Long authorId, VacanciesCreateDto dto) throws VacancyDataCreateException;

    VacanciesDto update(Long vacancyId, VacanciesUpdateDto dto) throws VacancyNotFoundException, VacancyDataUpdateException;

    void delete(Long resumeId) throws VacancyNotFoundException;
}
