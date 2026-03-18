package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.VacancyDao;
import kg.job.jobsearch.dto.VacanciesDto;
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
    public List<VacanciesDto> getALLVacancies(){
        List<Vacancy> vacancies = vacancyDao.getALlVacancy();

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


}