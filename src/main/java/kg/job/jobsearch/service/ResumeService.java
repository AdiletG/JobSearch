package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.create.ResumeCreateDto;
import kg.job.jobsearch.dto.update.ResumeUpdateDto;
import kg.job.jobsearch.dto.ResumesDto;

import java.util.List;

public interface ResumeService {

    ResumeUpdateDto getById(Long id);

    List<ResumesDto> getAllResume();

    List<ResumesDto> getResumeByCategory(Long category);

    List<ResumesDto> getResumeByApplicant(Long applicantId);

    List<ResumesDto> getResumeByActive(boolean active);

    void createResume(Long applicantId, ResumeCreateDto dto);

    ResumesDto updateResume(Long resumeId, ResumeUpdateDto dto);

    void deleteResume(Long resumeId);
}
