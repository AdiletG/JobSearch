package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.model.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    @Query(
            value = "SELECT v FROM Vacancy v LEFT JOIN v.respondedApplicants resp GROUP BY v ORDER BY COUNT(resp) DESC",
            countQuery = "SELECT COUNT(v) FROM Vacancy v"
    )
    Page<Vacancy> findAllOrderByResponsesCountDesc(Pageable pageable);

    @Query("SELECT v FROM Vacancy v WHERE v.author.id = :authorId")
    List<Vacancy> findAllByAuthor(@Param("authorId") Long authorId);
    List<Vacancy> getVacancyByCategory(Long category);
    List<Vacancy> getVacancyByIsActive(boolean active);
    @Query("SELECT ra.vacancy FROM RespondedApplicant ra WHERE ra.resume.applicant.id = :userId")
    List<Vacancy> getVacanciesByApplicant(@Param("userId") Long userId);
}
