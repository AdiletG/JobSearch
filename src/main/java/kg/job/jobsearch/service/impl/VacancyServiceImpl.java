package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.enums.AccountType;
import kg.job.jobsearch.service.UserService;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final UserService userService;

    private final List<VacanciesDto> vacancies = new ArrayList<>(
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
    public void createVacancy(Integer userId, VacanciesDto vacanciesDto){
        UsersDto user = userService.getUserById(userId);

        if (user.getAccount_type() != AccountType.EMPLOYER) {
            throw new RuntimeException("Only employer can create vacancy");
        }


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
    public void editVacancy(Integer userId, Integer vacancyId, VacanciesDto vacanciesDto){
        UsersDto user = userService.getUserById(userId);

        if (user.getAccount_type() != AccountType.EMPLOYER) {
            throw new RuntimeException("Only employer can create vacancy");
        }
        VacanciesDto vacancy = vacancies.stream()
                .filter(v -> v.getId() == vacancyId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Vacancy not found"));

        if (vacancy.getAuthor_id() != userId) {
            throw new RuntimeException("You can edit only your own vacancy");
        }

        vacancy.setName(vacanciesDto.getName());
        vacancy.setDescription(vacanciesDto.getDescription());
        vacancy.setCategory_id(vacanciesDto.getCategory_id());
        vacancy.setSalary(vacanciesDto.getSalary());
        vacancy.setExp_from(vacanciesDto.getExp_from());
        vacancy.setExp_to(vacanciesDto.getExp_to());
        vacancy.setUpdate_time(LocalDateTime.now());
    }

    @Override
    public void deleteVacancy(Integer userId, Integer vacancyId){
        UsersDto user = userService.getUserById(userId);

        if (user.getAccount_type() != AccountType.EMPLOYER) {
            throw new RuntimeException("Only employer can create vacancy");
        }

        VacanciesDto vacancy = vacancies.stream()
                .filter(v -> v.getId() == vacancyId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Vacancy not found"));

        if (vacancy.getAuthor_id() != userId) {
            throw new RuntimeException("You can delete only your own vacancy");
        }

        vacancy.set_active(false);
    }

    @Override
    public VacanciesDto getVacancyById(Integer id){
        return vacancies.stream()
                .filter(vacancy -> vacancy.getId() == id)
                .findFirst()
                .orElse(null);
    }
}