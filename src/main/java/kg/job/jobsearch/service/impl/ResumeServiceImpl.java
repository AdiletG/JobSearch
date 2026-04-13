package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.*;
import kg.job.jobsearch.dto.*;
import kg.job.jobsearch.dto.create.ContactsInfoCreateDto;
import kg.job.jobsearch.dto.create.EducationInfoCreateDto;
import kg.job.jobsearch.dto.create.ResumeCreateDto;
import kg.job.jobsearch.dto.create.WorkExperienceInfoCreateDto;
import kg.job.jobsearch.dto.update.ContactsInfoUpdateDto;
import kg.job.jobsearch.dto.update.EducationInfoUpdateDto;
import kg.job.jobsearch.dto.update.ResumeUpdateDto;
import kg.job.jobsearch.dto.update.WorkExperienceInfoUpdateDto;
import kg.job.jobsearch.exception.notFoundException.ContactsInfoNotFoundException;
import kg.job.jobsearch.exception.notFoundException.EducationNotFoundException;
import kg.job.jobsearch.exception.notFoundException.ResumeNotFoundException;
import kg.job.jobsearch.exception.notFoundException.WorkExperienceInfoNotFoundException;
import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@RequiredArgsConstructor
@Transactional
public class ResumeServiceImpl implements ResumeService {
    private final ResumeDao resumeDao;
    private final ContactsInfoDao contactsInfoDao;
    private final EducationInfoDao educationInfoDao;
    private final WorkExperienceInfoDao workExperienceInfoDao;
    private final RespondedApplicantDao applicantDao;

    @Override
    public ResumeUpdateDto getById(Long id) throws ResumeNotFoundException {
        ResumeUpdateDto resume = resumeDao.getByIdForUpdate(id);

        List<EducationInfoUpdateDto> education = educationInfoDao.getByResumeIdByUpdate(resume.getId());
        List<WorkExperienceInfoUpdateDto> work = workExperienceInfoDao.getUpdateList(resume.getId());
        List<ContactsInfoUpdateDto> contact = contactsInfoDao.getUpdate(resume.getId());

        return ResumeUpdateDto.builder()
                .id(resume.getId())
                .name(resume.getName())
                .categoryId(resume.getCategoryId())
                .salary(resume.getSalary())
                .isActive(resume.getIsActive())
                .educations(education)
                .workExperiences(work)
                .contacts(contact)
                .build();
    }

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
    public List<ResumesDto> getResumeByCategory(Long category) throws ResumeNotFoundException {
        List<Resume> resumes = resumeDao.getResumeByCategory(category);
        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }

        return  resumes.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<ResumesDto> getResumeByApplicant(Long applicantId) throws ResumeNotFoundException {
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

        if(dto.getEducations() != null){
            for(EducationInfoCreateDto education : dto.getEducations()){
                educationInfoDao.save(resumeId, education);
            }
        }

        if(dto.getContacts() != null){
            for(ContactsInfoCreateDto contact : dto.getContacts()){
                contactsInfoDao.save(resumeId, contact);
            }
        }

        if(dto.getWorkExperiences() != null){
            for(WorkExperienceInfoCreateDto work : dto.getWorkExperiences()){
                workExperienceInfoDao.save(resumeId, work);
            }
        }

    }

    @Override
    public ResumesDto updateResume(Long resumeId, ResumeUpdateDto dto) throws ResumeNotFoundException, EducationNotFoundException, WorkExperienceInfoNotFoundException, ContactsInfoNotFoundException {
        Resume resume = resumeDao.getResumeById(resumeId)
                .orElseThrow(ResumeNotFoundException::new);

        if (dto.getName() != null) {
            resume.setName(dto.getName());
        }

        if (dto.getSalary() != null) {
            resume.setSalary(dto.getSalary());
        }

        if (dto.getCategoryId() != null) {
            resume.setCategoryId(dto.getCategoryId());
        }

        resumeDao.updateResume(resumeId, resume);

        if (dto.getContacts() != null) {
            contactsInfoDao.delete(resumeId);
            for (ContactsInfoUpdateDto cDto : dto.getContacts()) {
                ContactsInfoCreateDto createDto = ContactsInfoCreateDto.builder()
                        .type_id(cDto.getType_id())
                        .contactValue(cDto.getContactValue())
                        .build();
                contactsInfoDao.save(resumeId, createDto);
            }
        }

        if (dto.getEducations() != null) {
            educationInfoDao.deleteById(resumeId);
            for (EducationInfoUpdateDto eDto : dto.getEducations()) {
                    EducationInfoCreateDto createDto = EducationInfoCreateDto.builder()
                            .institution(eDto.getInstitution())
                            .program(eDto.getProgram())
                            .startDate(eDto.getStartDate())
                            .endDate(eDto.getEndDate())
                            .degree(eDto.getDegree())
                            .build();
                    educationInfoDao.save(resumeId, createDto);
                }
        }

        if (dto.getWorkExperiences() != null) {
            workExperienceInfoDao.deleteById(resumeId);
            for (WorkExperienceInfoUpdateDto wDto : dto.getWorkExperiences()) {
                    WorkExperienceInfoCreateDto createDto = WorkExperienceInfoCreateDto.builder()
                            .years(wDto.getYears())
                            .companyName(wDto.getCompanyName())
                            .position(wDto.getPosition())
                            .responsibilities(wDto.getResponsibilities())
                            .build();
                    workExperienceInfoDao.save(resumeId, createDto);

            }
        }

        Resume updatedResume = resumeDao.getResumeById(resumeId)
                .orElseThrow(ResumeNotFoundException::new);
        return mapToDto(updatedResume);
    }

    @Override
    public void deleteResume(Long resumeId) throws ResumeNotFoundException {
        resumeDao.getResumeById(resumeId)
                .orElseThrow(ResumeNotFoundException::new);

        educationInfoDao.deleteById(resumeId);
        workExperienceInfoDao.deleteById(resumeId);
        contactsInfoDao.delete(resumeId);
        applicantDao.deleteResume(resumeId);
        resumeDao.deleteResume(resumeId);

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