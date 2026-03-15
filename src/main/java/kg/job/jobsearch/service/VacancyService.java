package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.VacanciesDto;

import java.util.List;

public interface VacancyService {

    List<VacanciesDto> searchVacancies(Integer categoryId, Integer authorId, Boolean isActive);

    void createVacancy(Integer userId, VacanciesDto vacanciesDto);

    void editVacancy(Integer userId, Integer vacancyId, VacanciesDto vacanciesDto);

    void deleteVacancy(Integer userId, Integer vacancyId);

    VacanciesDto getVacancyById(Integer id);
}
