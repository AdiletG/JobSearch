package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.RespondedApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RespondedApplicantRepository extends JpaRepository<RespondedApplicant, Long> {
    @Modifying
    @Query("DELETE FROM RespondedApplicant e WHERE e.resume.id = :resumeId")
    void deleteByResumeId(@Param("resumeId") Long resumeId);

    @Modifying
    @Query("DELETE FROM RespondedApplicant e WHERE e.vacancy.id = :vacancyId")
    void deleteByVacancyId(@Param("vacancyId") Long vacancyId);
}
