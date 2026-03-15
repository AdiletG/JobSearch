package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.VacanciesDto;

import java.util.List;

public interface VacancyService {

    List<VacanciesDto> searchVacancies(Integer categoryId, Integer authorId, Boolean isActive);

    void createVacancy(VacanciesDto vacanciesDto);

    void editVacancy(int id, VacanciesDto vacanciesDto);

    void deleteVacancy(int id);
}
