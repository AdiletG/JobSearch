package kg.job.jobsearch.repository;

import kg.job.jobsearch.dto.update.ContactsInfoUpdateDto;
import kg.job.jobsearch.model.ContactsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactInfoRepository extends JpaRepository<ContactsInfo, Long> {
    List<ContactsInfoUpdateDto> getContactsInfoBy(Long resumeId);

    @Modifying
    @Query("DELETE FROM ContactsInfo e WHERE e.resume.id = :resumeId")
    void deleteByResumeId(@Param("resumeId") Long resumeId);
}
