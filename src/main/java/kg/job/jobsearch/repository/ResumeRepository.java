package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> getResumeByCategory(Long categoryId);
    List<Resume> getResumeByApplicant(Long applicantId);
    List<Resume> getResumeByActive(Boolean isActive);


}
