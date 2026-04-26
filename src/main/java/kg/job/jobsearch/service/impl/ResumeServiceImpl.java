package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.*;
import kg.job.jobsearch.dto.create.ContactsInfoCreateDto;
import kg.job.jobsearch.dto.create.EducationInfoCreateDto;
import kg.job.jobsearch.dto.create.ResumeCreateDto;
import kg.job.jobsearch.dto.create.WorkExperienceInfoCreateDto;
import kg.job.jobsearch.dto.update.ContactsInfoUpdateDto;
import kg.job.jobsearch.dto.update.EducationInfoUpdateDto;
import kg.job.jobsearch.dto.update.ResumeUpdateDto;
import kg.job.jobsearch.dto.update.WorkExperienceInfoUpdateDto;
import kg.job.jobsearch.exception.createException.ResumeDataCreateException;
import kg.job.jobsearch.exception.notFoundException.*;
import kg.job.jobsearch.model.*;
import kg.job.jobsearch.repository.*;
import kg.job.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
    private final ResumeRepository resumeRepository;
    private final ContactInfoRepository contactInfoRepository;
    private final EducationInfoRepository educationInfoRepository;
    private final WorkExperienceInfoRepository experienceInfoRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ContactTypeRepository contactTypeRepository;
    private final RespondedApplicantRepository respondedApplicantRepository;

    @Override
    public Page<Resume> findByApplicantFromPage(Long applicantId, Pageable pageable){
        return resumeRepository.findResumeByApplicant_Id(applicantId, pageable);
    }

    @Override
    public ResumeUpdateDto getById(Long id){
        Resume resume = resumeRepository.findById(id)
                .orElseThrow(ResumeNotFoundException::new);

        List<EducationInfo> educationEntities = educationInfoRepository.findAllByResume_Id(resume.getId());
        List<WorkExperienceInfo> workEntities = experienceInfoRepository.findAllByResume_Id(resume.getId());
        List<ContactsInfo> contactEntities = contactInfoRepository.findAllByResume_Id(resume.getId());

        List<EducationInfoUpdateDto> educationDtos = new ArrayList<>(educationEntities.stream()
                .map(e -> EducationInfoUpdateDto.builder()
                        .id(e.getId())
                        .institution(e.getInstitution())
                        .program(e.getProgram())
                        .startDate(e.getStartDate())
                        .endDate(e.getEndDate())
                        .degree(e.getDegree())
                        .build())
                .toList());

        List<WorkExperienceInfoUpdateDto> workDtos = new ArrayList<>(workEntities.stream()
                .map(w -> WorkExperienceInfoUpdateDto.builder()
                        .id(w.getId())
                        .companyName(w.getCompanyName())
                        .position(w.getPosition())
                        .years(w.getYears())
                        .responsibilities(w.getResponsibilities())
                        .build())
                .toList());

        List<ContactsInfoUpdateDto> contactDtos = new ArrayList<>(contactEntities.stream()
                .map(c -> ContactsInfoUpdateDto.builder()
                        .id(c.getId())
                        .type_id(c.getType().getId())
                        .contactValue(c.getContactValue())
                        .build())
                .toList());
        return ResumeUpdateDto.builder()
                .id(resume.getId())
                .name(resume.getName())
                .categoryId(resume.getCategory().getId())
                .salary(resume.getSalary())
                .isActive(resume.getIsActive())
                .educations(educationDtos)
                .workExperiences(workDtos)
                .contacts(contactDtos)
                .build();
    }

    @Override
    public Page<Resume> findAllOrderByResponsesCountDesc(Pageable pageable) {
        return resumeRepository.findAllOrderByResponsesCountDesc(pageable);
    }

    @Override
    public Page<Resume> findResumesByPage(Pageable pageable) {
            return resumeRepository.findAll(pageable);
    }

    @Override
    public List<ResumesDto> getAllResume(){

        List<Resume> resumes = resumeRepository.findAll();

        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }

        return resumes.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<ResumesDto> getResumeByCategory(Long category){
        List<Resume> resumes = resumeRepository.findAllByCategory_Id(category);
        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }

        return  resumes.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<ResumesDto> getResumeByApplicant(Long applicantId){
        List<Resume> resumes = resumeRepository.findAllByApplicant_Id(applicantId);

        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }
        return resumes.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<ResumesDto> getResumeByActive(boolean active){
        List<Resume> resumes = resumeRepository.findAllByIsActive(active);

        if(resumes.isEmpty()){
            throw new ResumeNotFoundException();
        }

        return resumes.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    @Transactional
    public void createResume(Long applicantId, ResumeCreateDto dto){
        try {
            Resume resume = new Resume();
            resume.setName(dto.getName());
            resume.setSalary(dto.getSalary());
            resume.setIsActive(true);

            User user = userRepository.findById(applicantId)
                    .orElseThrow(UserNotFoundException::new);
            resume.setApplicant(user);

            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(CategoryNotFoundException::new);
            resume.setCategory(category);

            Resume savedResume = resumeRepository.save(resume);

            if (dto.getEducations() != null) {
                for (EducationInfoCreateDto education : dto.getEducations()) {
                    EducationInfo edu = new EducationInfo();
                    edu.setInstitution(education.getInstitution());
                    edu.setProgram(education.getProgram());
                    edu.setStartDate(education.getStartDate());
                    edu.setEndDate(education.getEndDate());
                    edu.setDegree(education.getDegree());
                    edu.setResume(savedResume);

                    educationInfoRepository.save(edu);
                }
            }

            if (dto.getContacts() != null) {
                for (ContactsInfoCreateDto contact : dto.getContacts()) {
                    ContactsInfo contactsInfo = new ContactsInfo();

                    ContactType contactType = contactTypeRepository.findById(contact.getType_id())
                            .orElseThrow(ContactsInfoNotFoundException::new);

                    contactsInfo.setType(contactType);
                    contactsInfo.setContactValue(contact.getContactValue());
                    contactsInfo.setResume(savedResume);

                    contactInfoRepository.save(contactsInfo);
                }
            }

            if (dto.getWorkExperiences() != null) {
                for (WorkExperienceInfoCreateDto work : dto.getWorkExperiences()) {
                    WorkExperienceInfo workExperienceInfo = new WorkExperienceInfo();
                    workExperienceInfo.setCompanyName(work.getCompanyName());
                    workExperienceInfo.setPosition(work.getPosition());
                    workExperienceInfo.setYears(work.getYears());
                    workExperienceInfo.setResponsibilities(work.getResponsibilities());
                    workExperienceInfo.setResume(savedResume);

                    experienceInfoRepository.save(workExperienceInfo);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new ResumeDataCreateException();
        }

    }

    @Override
    @Transactional
    public ResumesDto updateResume(Long resumeId, ResumeUpdateDto dto){
//        SecurityContextHolder.getContext().getAuthentication().getName();
        
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(ResumeNotFoundException::new);

        if (dto.getName() != null) {
            resume.setName(dto.getName());
        }

        if (dto.getSalary() != null) {
            resume.setSalary(dto.getSalary());
        }

        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(CategoryNotFoundException::new);
            resume.setCategory(category);
        }

        if (dto.getContacts() != null) {
            contactInfoRepository.deleteByResumeId(resumeId);
            for (ContactsInfoUpdateDto cDto : dto.getContacts()) {
                ContactsInfo contact = new ContactsInfo();
                contact.setResume(resume);
                contact.setContactValue(cDto.getContactValue());
                contact.setType(contactTypeRepository.findById(cDto.getType_id()).orElseThrow());
                contactInfoRepository.save(contact);
            }
        }

        if (dto.getEducations() != null) {
            educationInfoRepository.deleteByResumeId(resumeId);
            for (EducationInfoUpdateDto eDto : dto.getEducations()) {
                EducationInfo edu = new EducationInfo();
                edu.setResume(resume);
                edu.setInstitution(eDto.getInstitution());
                edu.setProgram(eDto.getProgram());
                edu.setStartDate(eDto.getStartDate());
                edu.setEndDate(eDto.getEndDate());
                edu.setDegree(eDto.getDegree());
                educationInfoRepository.save(edu);
            }
        }

        if (dto.getWorkExperiences() != null) {
            experienceInfoRepository.deleteByResumeId(resumeId);
            for (WorkExperienceInfoUpdateDto wDto : dto.getWorkExperiences()) {
                WorkExperienceInfo exp = new WorkExperienceInfo();
                exp.setResume(resume);
                exp.setYears(wDto.getYears());
                exp.setCompanyName(wDto.getCompanyName());
                exp.setPosition(wDto.getPosition());
                exp.setResponsibilities(wDto.getResponsibilities());
                experienceInfoRepository.save(exp);
            }
        }

        Resume saved = resumeRepository.save(resume);
        return mapToDto(saved);    }

    @Override
    @Transactional
    public void deleteResume(Long resumeId){
        resumeRepository.findById(resumeId)
                .orElseThrow(ResumeNotFoundException::new);

        educationInfoRepository.deleteByResumeId(resumeId);
        experienceInfoRepository.deleteByResumeId(resumeId);
        contactInfoRepository.deleteByResumeId(resumeId);
        respondedApplicantRepository.deleteByResumeId(resumeId);
        resumeRepository.deleteById(resumeId);

    }

    private ResumesDto mapToDto(Resume resume) {
        return ResumesDto.builder()
                .id(resume.getId())
                .applicantId(resume.getApplicant().getId())
                .name(resume.getName())
                .categoryId(resume.getCategory().getId())
                .salary(resume.getSalary())
                .isActive(resume.getIsActive())
                .createdDate(resume.getCreatedDate())
                .updateDate(resume.getUpdateDate())
                .build();
    }
}