package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.ResumeCreateDto;
import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.exception.ResumeNotFoundException;

import java.util.List;

public interface ResumeService {

    List<ResumesDto> getAllResume() throws ResumeNotFoundException;

    List<ResumesDto> getResumeByCategory(int category) throws ResumeNotFoundException;

    List<ResumesDto> getResumeByApplicant(int applicantId) throws ResumeNotFoundException;

    List<ResumesDto> getResumeByActive(boolean active) throws ResumeNotFoundException;

    void createResume(Long applicantId, ResumeCreateDto dto) throws ResumeNotFoundException;
}
