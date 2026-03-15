package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.dto.UsersDto;
import kg.job.jobsearch.enums.AccountType;
import kg.job.jobsearch.service.ResumeService;
import kg.job.jobsearch.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ResumeServiceImpl implements ResumeService {

    private UserService userService;

    private final List<ResumesDto> resumes = new ArrayList<>(
            List.of(
                    ResumesDto.builder()
                            .id(1)
                            .name("Driver")
                            .applicant_id(2)
                            .category_id(1)
                            .salary(15000)
                            .is_active(true)
                            .created_date(LocalDateTime.now())
                            .build()
            )
    );

    @Override
    public List<ResumesDto> searchResumes(Integer categoryId, Integer applicantId, Boolean isActive){
        Stream<ResumesDto> stream = resumes.stream();
        if(categoryId != null){
            stream = stream.filter( r -> r.getCategory_id() == categoryId);
        }

        if(applicantId != null){
            stream = stream.filter(r -> r.getApplicant_id() == applicantId);
        }

        if(isActive != null){
            stream = stream.filter(ResumesDto::is_active);
        }

        return stream.toList();
    }

    @Override
    public void createResume(Integer userId, ResumesDto resumesDto){
        UsersDto user = userService.getUserById(userId);

        if (user.getAccount_type() != AccountType.APPLICANT) {
            throw new RuntimeException("Only applicant can create vacancy");
        }

        int id = 0;

        for(ResumesDto r : resumes){
            if(r.getId() > id){
                id = r.getId();
            }
        }

        resumesDto.setId(id + 1);
        resumesDto.setCreated_date(LocalDateTime.now());
        resumesDto.set_active(true);

        resumes.add(resumesDto);
    }

    @Override
    public void editResume(Integer userId, Integer id, ResumesDto resumesDto){
        UsersDto user = userService.getUserById(userId);

        if (user.getAccount_type() != AccountType.APPLICANT) {
            throw new RuntimeException("Only employer can create vacancy");
        }
        ResumesDto resume = resumes.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        if (resume.getApplicant_id() != userId) {
            throw new RuntimeException("You can edit only your own resume");
        }
        resume.setName(resumesDto.getName());
        resume.setSalary(resumesDto.getSalary());
        resume.setCategory_id(resumesDto.getCategory_id());
        resume.setUpdate_time(LocalDateTime.now());
    }

    @Override
    public void deleteResume(Integer userId, Integer id){
        UsersDto user = userService.getUserById(userId);

        if (user.getAccount_type() != AccountType.APPLICANT) {
            throw new RuntimeException("Only employer can create resume");
        }

        ResumesDto resume = resumes.stream()
                .filter(r -> r.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        if (resume.getApplicant_id() != userId) {
            throw new RuntimeException("You can edit only your own resume");
        }

        resume.set_active(false);
    }

    @Override
    public ResumesDto getresumeById(Integer id){
        return resumes.stream()
                .filter(resume -> resume.getId() == id)
                .findFirst()
                .orElse(null);
    }
}