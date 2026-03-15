package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.ResumesDto;

import java.util.List;

public interface ResumeService {
    List<ResumesDto> searchResumes(Integer categoryId, Integer applicantId, Boolean isActive);

    void createResume(Integer userId, ResumesDto resumesDto);

    void editResume(Integer userId, Integer id, ResumesDto resumesDto);

    void deleteResume(Integer userId, Integer id);

    ResumesDto getresumeById(Integer id);
}
