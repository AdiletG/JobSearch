package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.WorkExperienceInfoDto;
import kg.job.jobsearch.exception.WorkExperienceInfoNotFoundException;

import java.util.List;

public interface WorkExperienceInfoService {
    List<WorkExperienceInfoDto> getAllWorkExperienceInfo() throws WorkExperienceInfoNotFoundException;
}
