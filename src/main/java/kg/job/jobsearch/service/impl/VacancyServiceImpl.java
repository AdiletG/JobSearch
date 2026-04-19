package kg.job.jobsearch.service.impl;

import jakarta.transaction.Transactional;
import kg.job.jobsearch.dto.create.VacanciesCreateDto;
import kg.job.jobsearch.dto.VacanciesDto;
import kg.job.jobsearch.dto.update.VacanciesUpdateDto;
import kg.job.jobsearch.exception.createException.VacancyDataCreateException;
import kg.job.jobsearch.exception.notFoundException.CategoryNotFoundException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.exception.notFoundException.VacancyNotFoundException;
import kg.job.jobsearch.exception.updateException.VacancyDataUpdateException;
import kg.job.jobsearch.model.Category;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.model.Vacancy;
import kg.job.jobsearch.repository.CategoryRepository;
import kg.job.jobsearch.repository.RespondedApplicantRepository;
import kg.job.jobsearch.repository.UserRepository;
import kg.job.jobsearch.repository.VacancyRepository;
import kg.job.jobsearch.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;
    private final RespondedApplicantRepository respondedApplicantRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public Page<Vacancy> findAllOrderByResponsesCountDesc(Pageable pageable){
        return vacancyRepository.findAllOrderByResponsesCountDesc(pageable);
    }

    @Override
    public Page<Vacancy> getVacancyByPage(Pageable pageable){
        return vacancyRepository.findAll(pageable);
    }

    @Override
    public VacanciesUpdateDto getByIdForUpdate(Long id){
        Vacancy vacancy =  vacancyRepository.findById(id)
                .orElseThrow(VacancyNotFoundException::new);
        return VacanciesUpdateDto.builder()
                .id(vacancy.getId())
                .name(vacancy.getName())
                .description(vacancy.getDescription())
                .categoryId(vacancy.getCategory().getId())
                .salary(vacancy.getSalary())
                .expFrom(vacancy.getExpFrom())
                .expTo(vacancy.getExpTo())
                .isActive(vacancy.getIsActive())
                .build();
    }

    @Override
    public List<VacanciesDto> getALLVacancies() {
        List<Vacancy> vacancies = vacancyRepository.findAll();

       return vacancies.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<VacanciesDto> getALLVacanciesByAuthor(Long id) {
        List<Vacancy> vacancies = vacancyRepository.findAllByAuthor(id);

        if (vacancies.isEmpty()) {
            throw new VacancyNotFoundException();
        }

        return vacancies.stream()
                .map(this::mapToDto)
                .toList();

    }
        @Override
    public List<VacanciesDto> getVacancyByCategory(Long category) {
        List<Vacancy> vacancies = vacancyRepository.getVacancyByCategory(category);

        if (vacancies.isEmpty()) {
            throw new VacancyNotFoundException();
        }

        return vacancies.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<VacanciesDto> getVacancyByActive(boolean active) {
        List<Vacancy> vacancies = vacancyRepository.getVacancyByIsActive(active);

        if (vacancies.isEmpty()) {
            throw new VacancyNotFoundException();
        }

        return vacancies.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<VacanciesDto> getVacanciesByApplicant(Long id) {
        List<Vacancy> vacancies = vacancyRepository.getVacanciesByApplicant(id);

        if (vacancies.isEmpty()) {
            throw new VacancyNotFoundException();
        }

        return vacancies.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public void createVacancy(Long authorId, VacanciesCreateDto dto)
            throws VacancyDataCreateException {
        try {
            Vacancy vacancy = new Vacancy();
            vacancy.setName(dto.getName());
            vacancy.setDescription(dto.getDescription());
            vacancy.setSalary(dto.getSalary());
            vacancy.setExpTo(dto.getExpTo());
            vacancy.setExpFrom(dto.getExpFrom());
            vacancy.setIsActive(true);

            User user = userRepository.findById(authorId)
                    .orElseThrow(UserNotFoundException::new);
            vacancy.setAuthor(user);

            Category category = categoryRepository.findById(dto.getCategoryId())
                            .orElseThrow(CategoryNotFoundException::new);
            vacancy.setCategory(category);

            vacancyRepository.save(vacancy);

        }catch (Exception e){
            e.printStackTrace();
            throw new VacancyDataCreateException();
        }

    }

    @Override
    @Transactional
    public VacanciesDto update(Long vacancyId, VacanciesUpdateDto dto){
        Vacancy vacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(VacancyNotFoundException::new);

        if (dto.getName() != null) {
            vacancy.setName(dto.getName());
        }

        if(dto.getDescription() != null){
            vacancy.setDescription(dto.getDescription());
        }

        if(dto.getCategoryId() != null){
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(CategoryNotFoundException::new);
            vacancy.setCategory(category);
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



        vacancyRepository.save(vacancy);
        Vacancy updatedVacancy = vacancyRepository.findById(vacancyId)
                .orElseThrow(VacancyDataUpdateException::new);
        return mapToDto(updatedVacancy);
    }

    @Override
    @Transactional
    public void delete(Long vacancyId) {
        vacancyRepository.findById(vacancyId)
                .orElseThrow(VacancyNotFoundException::new);

        respondedApplicantRepository.deleteByVacancyId(vacancyId);
        vacancyRepository.deleteById(vacancyId);
    }

    private VacanciesDto mapToDto(Vacancy v) {
        return VacanciesDto.builder()
                .id(v.getId())
                .name(v.getName())
                .description(v.getDescription())
                .categoryId(v.getCategory().getId())
                .salary(v.getSalary())
                .expFrom(v.getExpFrom())
                .expTo(v.getExpTo())
                .isActive(v.getIsActive())
                .authorId(v.getAuthor().getId())
                .createdDate(v.getCreatedDate())
                .updateDate(v.getUpdateDate())
                .build();
    }
}