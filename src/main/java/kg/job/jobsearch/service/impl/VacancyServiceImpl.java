package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.service.VacancyService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class VacancyServiceImpl implements VacancyService {

    private List<VacanciesDto> vacancies = new ArrayList<>(
            List.of(
                    VacanciesDto.builder()
                            .id(1)
                            .name("Driver")
                            .description("Just drive")
                            .category_id(1)
                            .salary(1000)
                            .exp_from(1)
                            .exp_to(3)
                            .is_active(true)
                            .created_date(LocalDateTime.now())
                            .build()
            )
    );

    @Override
    public List<VacanciesDto> searchVacancies(Integer categoryId, Integer authorId, Boolean isActive){
        Stream<VacanciesDto> stream = vacancies.stream();
        if(categoryId != null){
            stream = stream.filter(v -> v.getCategory_id() == categoryId);
        }

        if(authorId != null){
            stream = stream.filter(v -> v.getAuthor_id() == authorId);
        }

        if(isActive != null){
            stream = stream.filter(VacanciesDto::is_active);
        }
        return stream.toList();
    }

    @Override
    public void createVacancy(VacanciesDto vacanciesDto){
        int id = 0;

        for(VacanciesDto v : vacancies){
            if(v.getId() > id){
                id = v.getId();
            }
        }

        vacanciesDto.setId(id + 1);
        vacanciesDto.setCreated_date(LocalDateTime.now());
        vacanciesDto.set_active(true);

        vacancies.add(vacanciesDto);
    }

    @Override
    public void editVacancy(int id, VacanciesDto vacanciesDto){
        vacancies.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .ifPresent(v -> {
                    v.setName(vacanciesDto.getName());
                    v.setDescription(vacanciesDto.getDescription());
                    v.setCategory_id(vacanciesDto.getCategory_id());
                    v.setSalary(vacanciesDto.getSalary());
                    v.setExp_from(vacanciesDto.getExp_from());
                    v.setExp_to(vacanciesDto.getExp_to());
                });
    }

    @Override
    public void deleteVacancy(int id){
        vacancies.removeIf(v -> v.getId() == id);
    }
}