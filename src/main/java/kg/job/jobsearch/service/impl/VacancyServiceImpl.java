package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.VacancyDao;
import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.exception.VacancyNotFoundException;
import kg.job.jobsearch.model.Vacancy;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyDao vacancyDao;

    @Override
    public List<VacanciesDto> getALLVacancies() throws VacancyNotFoundException {
        List<Vacancy> vacancies = vacancyDao.getALlVacancy();
        if(vacancies.isEmpty()){
            throw new VacancyNotFoundException();
        }
        List<VacanciesDto> result = new ArrayList<>();
        vacancies.forEach(v -> {
            VacanciesDto vacancy = VacanciesDto.builder()
                    .id(v.getId())
                    .name(v.getName())
                    .description(v.getDescription())
                    .category_id(v.getCategory_id())
                    .salary(v.getSalary())
                    .exp_from(v.getExp_from())
                    .exp_to(v.getExp_to())
                    .is_active(v.getIs_active())
                    .author_id(v.getAuthor_id())
                    .created_date(v.getCreated_date())
                    .update_time(v.getUpdate_time())
                    .build();
            result.add(vacancy);
        });

        return result;
    }

    @Override
    public List<VacanciesDto> getVacancyByCategory(int category) throws VacancyNotFoundException {
        List<Vacancy> vacancies = vacancyDao.getVacancyByCategory(category);

        if(vacancies.isEmpty()){
            throw new VacancyNotFoundException();
        }

        return vacancies.stream()
                .map(v ->
                        VacanciesDto.builder()
                                .id(v.getId())
                                .name(v.getName())
                                .description(v.getDescription())
                                .category_id(v.getCategory_id())
                                .salary(v.getSalary())
                                .exp_from(v.getExp_from())
                                .exp_to(v.getExp_to())
                                .is_active(v.getIs_active())
                                .author_id(v.getAuthor_id())
                                .created_date(v.getCreated_date())
                                .update_time(v.getUpdate_time())
                                .build())
                .toList();
    }

    @Override
    public List<VacanciesDto> getVacancyByActive(boolean active) throws VacancyNotFoundException {
        List<Vacancy> vacancies = vacancyDao.getVacancyByActive(active);

        if(vacancies.isEmpty()){
            throw new VacancyNotFoundException();
        }

        return vacancies.stream()
                .map(v ->
                        VacanciesDto.builder()
                                .id(v.getId())
                                .name(v.getName())
                                .description(v.getDescription())
                                .category_id(v.getCategory_id())
                                .salary(v.getSalary())
                                .exp_from(v.getExp_from())
                                .exp_to(v.getExp_to())
                                .is_active(v.getIs_active())
                                .author_id(v.getAuthor_id())
                                .created_date(v.getCreated_date())
                                .update_time(v.getUpdate_time())
                                .build())
                .toList();
    }

}