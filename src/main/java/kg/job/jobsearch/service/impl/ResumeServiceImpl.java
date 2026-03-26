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
import kg.job.jobsearch.model.ContactsInfo;
import kg.job.jobsearch.model.EducationInfo;
import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.model.WorkExperienceInfo;
import kg.job.jobsearch.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
    private final ResumeDao resumeDao;
    private final ContactsInfoDao contactsInfoDao;
    private final EducationInfoDao educationInfoDao;
    private final WorkExperienceInfoDao workExperienceInfoDao;
    private final RespondedApplicantDao applicantDao;

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

        for(ContactsInfoCreateDto contact : dto.getContacts()){
            contactsInfoDao.save(resumeId, contact);
        }

        for(EducationInfoCreateDto education : dto.getEducations()){
            educationInfoDao.save(resumeId, education);
        }

        for(WorkExperienceInfoCreateDto work : dto.getWorkExperiences()){
            workExperienceInfoDao.save(resumeId, work);
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
            syncContacts(resumeId, dto.getContacts());
        }

        if (dto.getEducations() != null) {
            syncEducations(resumeId, dto.getEducations());
        }

        if (dto.getWorkExperiences() != null) {
            syncWorkExperiences(resumeId, dto.getWorkExperiences());
        }

        Resume updatedResume = resumeDao.getResumeById(resumeId)
                .orElseThrow(ResumeNotFoundException::new);
        return mapToDto(updatedResume);
    }

    private void syncContacts(Long resumeId, List<ContactsInfoUpdateDto> incomingContacts) throws ContactsInfoNotFoundException {
        List<ContactsInfo> existingContact = contactsInfoDao.getByResumeId(resumeId);

        Map<Long, ContactsInfo> existingMap = existingContact.stream()
                .collect(Collectors.toMap(ContactsInfo::getId, education -> education));

        Set<Long> incomingIds = new HashSet<>();

        for (ContactsInfoUpdateDto dto : incomingContacts) {
            if (dto.getId() == null) {
                ContactsInfoCreateDto createDto = ContactsInfoCreateDto.builder()
                        .type_id(dto.getType_id())
                        .contactValue(dto.getContactValue())
                        .build();
                contactsInfoDao.save(resumeId, createDto);
            } else {
                incomingIds.add(dto.getId());

                ContactsInfo existing = existingMap.get(dto.getId());
                if (existing == null) {
                    throw new ContactsInfoNotFoundException("Education with id " + dto.getId() + " not found for resume " + resumeId);
                }

                contactsInfoDao.update(dto.getId(), dto);
            }
        }
    }

    private void syncEducations(Long resumeId, List<EducationInfoUpdateDto> incomingEducations) throws EducationNotFoundException {
        List<EducationInfo> existingEducations = educationInfoDao.getByResumeId(resumeId);

        Map<Long, EducationInfo> existingMap = existingEducations.stream()
                .collect(Collectors.toMap(EducationInfo::getId, education -> education));

        Set<Long> incomingIds = new HashSet<>();

        for (EducationInfoUpdateDto dto : incomingEducations) {
            if (dto.getId() == null) {
                EducationInfoCreateDto createDto = EducationInfoCreateDto.builder()
                        .institution(dto.getInstitution())
                        .program(dto.getProgram())
                        .startDate(dto.getStartDate())
                        .endDate(dto.getEndDate())
                        .degree(dto.getDegree())
                        .build();
                educationInfoDao.save(resumeId, createDto);
            } else {
                incomingIds.add(dto.getId());

                EducationInfo existing = existingMap.get(dto.getId());
                if (existing == null) {
                    throw new EducationNotFoundException("Education with id " + dto.getId() + " not found for resume " + resumeId);
                }

                educationInfoDao.update(dto.getId(), dto);
            }
        }
    }

    private void syncWorkExperiences(Long resumeId, List<WorkExperienceInfoUpdateDto> incomingWorks) throws WorkExperienceInfoNotFoundException {
        List<WorkExperienceInfo> existingWorks = workExperienceInfoDao.getByResumeId(resumeId);

        Map<Long, WorkExperienceInfo> existingMap = existingWorks.stream()
                .collect(Collectors.toMap(WorkExperienceInfo::getId, work -> work));

        Set<Long> incomingIds = new HashSet<>();

        for (WorkExperienceInfoUpdateDto dto : incomingWorks) {
            if (dto.getId() == null) {
                WorkExperienceInfoCreateDto createDto = WorkExperienceInfoCreateDto.builder()
                        .years(dto.getYears())
                        .companyName(dto.getCompanyName())
                        .position(dto.getPosition())
                        .responsibilities(dto.getResponsibilities())
                        .build();
                workExperienceInfoDao.save(resumeId, createDto);
            } else {
                incomingIds.add(dto.getId());

                WorkExperienceInfo existing = existingMap.get(dto.getId());
                if (existing == null) {
                    throw new WorkExperienceInfoNotFoundException("Work experience with id " + dto.getId() + " not found for resume " + resumeId);
                }

                workExperienceInfoDao.update(dto.getId(), dto);
            }
        }
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