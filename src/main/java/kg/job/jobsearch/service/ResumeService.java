package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.create.ResumeCreateDto;
import kg.job.jobsearch.dto.update.ResumeUpdateDto;
import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.exception.createException.ResumeDataCreateException;
import kg.job.jobsearch.exception.notFoundException.*;

import java.util.List;

public interface ResumeService {

    ResumeUpdateDto getById(Long id) throws ResumeNotFoundException;

    List<ResumesDto> getAllResume() throws ResumeNotFoundException;

    List<ResumesDto> getResumeByCategory(Long category) throws ResumeNotFoundException;

    List<ResumesDto> getResumeByApplicant(Long applicantId) throws ResumeNotFoundException;

    List<ResumesDto> getResumeByActive(boolean active) throws ResumeNotFoundException;

    void createResume(Long applicantId, ResumeCreateDto dto) throws ResumeNotFoundException, ResumeDataCreateException;

    ResumesDto updateResume(Long resumeId, ResumeUpdateDto dto) throws ResumeNotFoundException, EducationNotFoundException, WorkExperienceInfoNotFoundException, ContactsInfoNotFoundException, CategoryNotFoundException;

    void deleteResume(Long resumeId) throws ResumeNotFoundException;
}
