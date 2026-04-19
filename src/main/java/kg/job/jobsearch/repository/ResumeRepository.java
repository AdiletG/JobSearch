package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.Resume;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    @Query(
            value = "SELECT r FROM Resume r LEFT JOIN r.respondedApplicants resp GROUP BY r ORDER BY COUNT(resp) DESC",
            countQuery = "SELECT COUNT(r) FROM Resume r"
    )
    Page<Resume> findAllOrderByResponsesCountDesc(Pageable pageable);

    Page<Resume> findByCategory_Id(Long categoryId, Pageable pageable);

    List<Resume> findAllByCategory_Id(Long categoryId);

    List<Resume> findAllByApplicant_Id(Long applicantId);

    List<Resume> findAllByIsActive(Boolean isActive);

}
