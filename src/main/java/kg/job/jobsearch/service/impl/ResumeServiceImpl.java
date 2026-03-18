package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.ResumeDao;
import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.exception.ResumeNotFoundException;
import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
    private final ResumeDao resumeDao;

    @Override
    public List<ResumesDto> getAllResume() throws ResumeNotFoundException {
        List<Resume> resume = resumeDao.getAllResume();

        if(resume.isEmpty()){
            throw new ResumeNotFoundException();
        }

        List<ResumesDto> result = new ArrayList<>();
        resume.forEach(r -> {
            ResumesDto resumes = ResumesDto.builder()
                    .id(r.getId())
                    .applicant_id(r.getApplicant_id())
                    .name(r.getName())
                    .category_id(r.getCategory_id())
                    .salary(r.getSalary())
                    .is_active(r.getIs_active())
                    .created_date(r.getCreated_date())
                    .update_time(r.getUpdate_time())
                    .build();
            result.add(resumes);
        });

        return result;
    }

    @Override
    public List<ResumesDto> getResumeByCategory(int category) throws ResumeNotFoundException {
        List<Resume> resumes = resumeDao.getResumeByCategory(category);
        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }

        return resumes.stream()
                .map(r -> ResumesDto.builder()
                        .id(r.getId())
                        .applicant_id(r.getApplicant_id())
                        .name(r.getName())
                        .category_id(r.getCategory_id())
                        .salary(r.getSalary())
                        .is_active(r.getIs_active())
                        .created_date(r.getCreated_date())
                        .update_time(r.getUpdate_time())
                        .build())
                .toList();
    }

    @Override
    public List<ResumesDto> getResumeByApplicant(int applicantId) throws ResumeNotFoundException {
        List<Resume> resumes = resumeDao.getResumeByApplicant(applicantId);

        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }
        return resumes.stream()
                .map(r -> ResumesDto.builder()
                        .id(r.getId())
                        .applicant_id(r.getApplicant_id())
                        .name(r.getName())
                        .category_id(r.getCategory_id())
                        .salary(r.getSalary())
                        .is_active(r.getIs_active())
                        .created_date(r.getCreated_date())
                        .update_time(r.getUpdate_time())
                        .build())
                .toList();
    }

    @Override
    public List<ResumesDto> getResumeByActive(boolean active) throws ResumeNotFoundException {
        List<Resume> resumes = resumeDao.getResumeByActive(active);

        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }

        return resumes.stream()
                .map(r -> ResumesDto.builder()
                        .id(r.getId())
                        .applicant_id(r.getApplicant_id())
                        .name(r.getName())
                        .category_id(r.getCategory_id())
                        .salary(r.getSalary())
                        .is_active(r.getIs_active())
                        .created_date(r.getCreated_date())
                        .update_time(r.getUpdate_time())
                        .build())
                .toList();
    }
}