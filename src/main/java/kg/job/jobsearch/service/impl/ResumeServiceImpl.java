package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.EducationInfoDao;
import kg.job.jobsearch.dao.ResumeDao;
import kg.job.jobsearch.dao.WorkExperienceInfoDao;
import kg.job.jobsearch.dto.*;
import kg.job.jobsearch.exception.ResumeNotFoundException;
import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
    private final ResumeDao resumeDao;
    private final EducationInfoDao educationInfoDao;
    private final WorkExperienceInfoDao workExperienceInfoDao;


    @Override
    public List<ResumesDto> getAllResume() throws ResumeNotFoundException {
        List<Resume> resumes = resumeDao.getAllResume();

        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }

        return resumes.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<ResumesDto> getResumeByCategory(int category) throws ResumeNotFoundException {
        List<Resume> resumes = resumeDao.getResumeByCategory(category);
        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }

        return  resumes.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<ResumesDto> getResumeByApplicant(int applicantId) throws ResumeNotFoundException {
        List<Resume> resumes = resumeDao.getResumeByApplicant(applicantId);

        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }
        return resumes.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<ResumesDto> getResumeByActive(boolean active) throws ResumeNotFoundException {
        List<Resume> resumes = resumeDao.getResumeByActive(active);

        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }

        return resumes.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public void createResume(Long applicantId, ResumeCreateDto dto) throws ResumeNotFoundException {
        Long resumeId = resumeDao.createResume(applicantId, dto);

        for(EducationInfoCreateDto education : dto.getEducations()){
            educationInfoDao.save(resumeId, education);
        }

        for(WorkExperienceInfoCreateDto work : dto.getWorkExperiences()){
            workExperienceInfoDao.save(resumeId, work);
        }
    }

    private ResumesDto mapToDto(Resume resume) {
        return ResumesDto.builder()
                .id(resume.getId())
                .applicantId(resume.getApplicantId())
                .name(resume.getName())
                .categoryId(resume.getCategoryId())
                .salary(resume.getSalary())
                .isActive(resume.getIsActive())
                .createdDate(resume.getCreatedDate())
                .updateDate(resume.getUpdateDate())
                .build();
    }
}