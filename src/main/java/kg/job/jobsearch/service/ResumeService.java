package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.ResumeCreateDto;
import kg.job.jobsearch.dto.ResumeUpdateDto;
import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.exception.ContactsInfoNotFoundException;
import kg.job.jobsearch.exception.EducationNotFoundException;
import kg.job.jobsearch.exception.ResumeNotFoundException;
import kg.job.jobsearch.exception.WorkExperienceInfoNotFoundException;

import java.util.List;

public interface ResumeService {

    List<ResumesDto> getAllResume() throws ResumeNotFoundException;

    List<ResumesDto> getResumeByCategory(int category) throws ResumeNotFoundException;

    List<ResumesDto> getResumeByApplicant(Long applicantId) throws ResumeNotFoundException;

    List<ResumesDto> getResumeByActive(boolean active) throws ResumeNotFoundException;

    void createResume(Long applicantId, ResumeCreateDto dto) throws ResumeNotFoundException;

    ResumesDto updateResume(Long resumeId, ResumeUpdateDto dto) throws ResumeNotFoundException, EducationNotFoundException, WorkExperienceInfoNotFoundException, ContactsInfoNotFoundException;

    void deleteResume(Long resumeId) throws ResumeNotFoundException;
}
