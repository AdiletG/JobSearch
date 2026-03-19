package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.ResumeDao;
import kg.job.jobsearch.dto.ResumesDto;
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