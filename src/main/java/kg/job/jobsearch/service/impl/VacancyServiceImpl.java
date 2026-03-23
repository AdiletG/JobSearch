package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.RespondedApplicantDao;
import kg.job.jobsearch.dao.VacancyDao;
import kg.job.jobsearch.dto.VacanciesCreateDto;
import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.dto.VacanciesUpdateDto;
import kg.job.jobsearch.exception.VacancyNotFoundException;
import kg.job.jobsearch.model.Vacancy;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyDao vacancyDao;
    private final RespondedApplicantDao applicantDao;

    @Override
    public List<VacanciesDto> getALLVacancies() throws VacancyNotFoundException {
        List<Vacancy> vacancies = vacancyDao.getALlVacancy();

        if (vacancies.isEmpty()) {
            throw new VacancyNotFoundException();
        }

        return vacancies.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<VacanciesDto> getVacancyByCategory(int category) throws VacancyNotFoundException {
        List<Vacancy> vacancies = vacancyDao.getVacancyByCategory(category);

        if (vacancies.isEmpty()) {
            throw new VacancyNotFoundException();
        }

        return vacancies.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<VacanciesDto> getVacancyByActive(boolean active) throws VacancyNotFoundException {
        List<Vacancy> vacancies = vacancyDao.getVacancyByActive(active);

        if (vacancies.isEmpty()) {
            throw new VacancyNotFoundException();
        }

        return vacancies.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<VacanciesDto> getVacanciesByApplicant(int id) throws VacancyNotFoundException {
        List<Vacancy> vacancies = vacancyDao.getVacanciesByApplicant(id);

        if (vacancies.isEmpty()) {
            throw new VacancyNotFoundException();
        }

        return vacancies.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public void createVacancy(Long authorId, VacanciesCreateDto dto){
        vacancyDao.createVacancy(authorId, dto);
    }

    @Override
    public VacanciesDto update(Long vacancyId, VacanciesUpdateDto dto) throws VacancyNotFoundException {
        Vacancy vacancy = vacancyDao.getVacancyById(vacancyId)
                .orElseThrow(VacancyNotFoundException::new);

        if (dto.getName() != null) {
            vacancy.setName(dto.getName());
        }

        if(dto.getDescription() != null){
            vacancy.setDescription(dto.getDescription());
        }

        if(dto.getCategoryId() != null){
            vacancy.setCategoryId(dto.getCategoryId());
        }

        if(dto.getSalary() != null){
            vacancy.setSalary(dto.getSalary());
        }

        if(dto.getExpFrom() != null){
            vacancy.setExpFrom(dto.getExpFrom());
        }

        if(dto.getExpTo() != null){
            vacancy.setExpTo(dto.getExpTo());
        }

        if(dto.getIsActive() != null){
            vacancy.setIsActive(dto.getIsActive());
        }

        vacancyDao.update(vacancyId, vacancy);
        Vacancy updatedVacancy = vacancyDao.getVacancyById(vacancyId)
                .orElseThrow(VacancyNotFoundException::new);
        return mapToDto(updatedVacancy);
    }

    @Override
    public void delete(Long resumeId) throws VacancyNotFoundException {
        vacancyDao.getVacancyById(resumeId)
                .orElseThrow(VacancyNotFoundException::new);

        applicantDao.deleteVacancy(resumeId);
        vacancyDao.delete(resumeId);

    }

    private VacanciesDto mapToDto(Vacancy v) {
        return VacanciesDto.builder()
                .id(v.getId())
                .name(v.getName())
                .description(v.getDescription())
                .categoryId(v.getCategoryId())
                .salary(v.getSalary())
                .expFrom(v.getExpFrom())
                .expTo(v.getExpTo())
                .isActive(v.getIsActive())
                .authorId(v.getAuthorId())
                .createdDate(v.getCreatedDate())
                .updateDate(v.getUpdateDate())
                .build();
    }
}