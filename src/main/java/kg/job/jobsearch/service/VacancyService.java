package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.create.VacanciesCreateDto;
import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.dto.update.VacanciesUpdateDto;
import kg.job.jobsearch.model.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VacancyService {

    Page<Vacancy> findByAuthorId(Long authorId, Pageable pageable);

    Page<Vacancy> findAllOrderByResponsesCountDesc(Pageable pageable);

    Page<Vacancy> getVacancyByPage(Pageable pageable);

    VacanciesUpdateDto getByIdForUpdate(Long id);

    List<VacanciesDto> getALLVacancies();

    List<VacanciesDto> getALLVacanciesByAuthor(Long id);

    List<VacanciesDto> getVacancyByCategory(Long category);

    List<VacanciesDto> getVacancyByActive(boolean active);

    List<VacanciesDto> getVacanciesByApplicant(Long id);

    void createVacancy(Long authorId, VacanciesCreateDto dto);

    VacanciesDto update(Long vacancyId, VacanciesUpdateDto dto);

    void delete(Long resumeId);
}
