package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findAllByAuthor(Long authorId);
    List<Vacancy> getVacancyByCategory(Long category);
    List<Vacancy> getVacancyByActive(boolean active);
    List<Vacancy> getVacanciesByApplicant(Long id);
}
