package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
