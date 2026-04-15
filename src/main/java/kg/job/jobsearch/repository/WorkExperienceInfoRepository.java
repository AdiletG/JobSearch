package kg.job.jobsearch.repository;

import kg.job.jobsearch.dto.update.WorkExperienceInfoUpdateDto;
import kg.job.jobsearch.model.WorkExperienceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkExperienceInfoRepository extends JpaRepository<WorkExperienceInfo, Long> {
    List<WorkExperienceInfoUpdateDto> getWorkExperienceInfoBy(Long resumeId);

    @Modifying
    @Query("DELETE FROM WorkExperienceInfo e WHERE e.resume.id = :resumeId")
    void deleteByResumeId(@Param("resumeId") Long resumeId);
}
