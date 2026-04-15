package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.WorkExperienceInfoDto;
import kg.job.jobsearch.exception.notFoundException.WorkExperienceInfoNotFoundException;
import kg.job.jobsearch.model.WorkExperienceInfo;
import kg.job.jobsearch.repository.WorkExperienceInfoRepository;
import kg.job.jobsearch.service.WorkExperienceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkExperienceServiceInfoImpl implements WorkExperienceInfoService {
    private final WorkExperienceInfoRepository workExperienceInfoRepository;

    @Override
    public List<WorkExperienceInfoDto> getAllWorkExperienceInfo() {
        List<WorkExperienceInfo> workExperienceInfos = workExperienceInfoRepository.findAll();
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