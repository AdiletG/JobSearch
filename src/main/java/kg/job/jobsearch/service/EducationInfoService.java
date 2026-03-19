package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.EducationInfoDto;
import kg.job.jobsearch.exception.EducationNotFoundException;

import java.util.List;

public interface EducationInfoService {
    List<EducationInfoDto> getAllEducationInfo() throws EducationNotFoundException;
}
