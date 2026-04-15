package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> findAllByCategory_Id(Long categoryId);

    List<Resume> findAllByApplicant_Id(Long applicantId);

    List<Resume> findAllByIsActive(Boolean isActive);

}
