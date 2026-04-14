package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.EducationInfoDao;
import kg.job.jobsearch.dto.EducationInfoDto;
import kg.job.jobsearch.dto.update.EducationInfoUpdateDto;
import kg.job.jobsearch.exception.notFoundException.EducationNotFoundException;
import kg.job.jobsearch.model.EducationInfo;
import kg.job.jobsearch.service.EducationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationInfoServiceImpl implements EducationInfoService {
    private final EducationInfoDao educationInfoDao;

    @Override
    public List<EducationInfoDto> getAllEducationInfo() throws EducationNotFoundException {
        List<EducationInfo> educationInfos = educationInfoDao.getAllEducationInfo();
        if(educationInfos.isEmpty()){
            throw new EducationNotFoundException();
        }
        return educationInfos.stream()
                .map(this::mapToDo)
                .toList();
    }

    private EducationInfoDto mapToDo(EducationInfo educationInfo){
        return EducationInfoDto.builder()
                .id(educationInfo.getId())
                .resumeId(educationInfo.getResume().getId())
                .institution(educationInfo.getInstitution())
                .program(educationInfo.getProgram())
                .startDate(educationInfo.getStartDate())
                .endDate(educationInfo.getEndDate())
                .degree(educationInfo.getDegree())
                .build();
    }
}