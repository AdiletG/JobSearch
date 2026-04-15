package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.RespondedApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespondedApplicantRepository extends JpaRepository<RespondedApplicant, Long> {
}
