package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.RespondedApplicantsDto;
import kg.job.jobsearch.exception.notFoundException.RespondedApplicantNotFoundException;
import kg.job.jobsearch.model.RespondedApplicant;
import kg.job.jobsearch.repository.RespondedApplicantRepository;
import kg.job.jobsearch.service.RespondedApplicantService;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RespondedApplicantImpl implements RespondedApplicantService {
    private final RespondedApplicantRepository respondedApplicantRepository;
    private final UserService userService;


    @Override
    public List<RespondedApplicantsDto> getAllRespond() throws RespondedApplicantNotFoundException {
        List<RespondedApplicant> respondedApplicants = respondedApplicantRepository.findAll();
        if(respondedApplicants.isEmpty()){
            throw new RespondedApplicantNotFoundException();
        }

        return respondedApplicants.stream()
                .map(this::mapToDo)
                .toList();
    }

    private RespondedApplicantsDto mapToDo(RespondedApplicant respondedApplicant){
        return RespondedApplicantsDto.builder()
                .id(respondedApplicant.getId())
                .resumeId(respondedApplicant.getResume().getId())
                .vacancyId(respondedApplicant.getVacancy().getId())
                .confirmation(respondedApplicant.getConfirmation())
                .build();
    }

}