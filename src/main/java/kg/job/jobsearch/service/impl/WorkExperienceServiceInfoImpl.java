package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.WorkExperienceInfoDao;
import kg.job.jobsearch.dto.WorkExperienceInfoDto;
import kg.job.jobsearch.exception.notFoundException.WorkExperienceInfoNotFoundException;
import kg.job.jobsearch.model.WorkExperienceInfo;
import kg.job.jobsearch.service.WorkExperienceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkExperienceServiceInfoImpl implements WorkExperienceInfoService {
    private final WorkExperienceInfoDao workExperienceInfoDao;

    @Override
    public List<WorkExperienceInfoDto> getAllWorkExperienceInfo() throws WorkExperienceInfoNotFoundException {
        List<WorkExperienceInfo> workExperienceInfos = workExperienceInfoDao.getAllWorkExperienceInfo();
        if(workExperienceInfos.isEmpty()){
            throw new WorkExperienceInfoNotFoundException();
        }

        return workExperienceInfos.stream()
                .map(this::mapToDo)
                .toList();
    }

    private WorkExperienceInfoDto mapToDo(WorkExperienceInfo workExperienceInfo){
        return WorkExperienceInfoDto.builder()
                .id(workExperienceInfo.getId())
                .resumeId(workExperienceInfo.getResume().getId())
                .years(workExperienceInfo.getYears())
                .companyName(workExperienceInfo.getCompanyName())
                .position(workExperienceInfo.getPosition())
                .responsibilities(workExperienceInfo.getResponsibilities())
                .build();
    }
}