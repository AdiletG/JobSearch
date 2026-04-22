package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.create.ResumeCreateDto;
import kg.job.jobsearch.dto.update.ResumeUpdateDto;
import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.model.Resume;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResumeService {

    ResumeUpdateDto getById(Long id);

    Page<Resume> findAllOrderByResponsesCountDesc(Pageable pageable, String username);

    Page<Resume> findResumesByPage(Pageable pageable);

    List<ResumesDto> getAllResume();

    List<ResumesDto> getResumeByCategory(Long category);

    List<ResumesDto> getResumeByApplicant(Long applicantId);

    List<ResumesDto> getResumeByActive(boolean active);

    void createResume(Long applicantId, ResumeCreateDto dto);

    ResumesDto updateResume(Long resumeId, ResumeUpdateDto dto);

    void deleteResume(Long resumeId);
}
