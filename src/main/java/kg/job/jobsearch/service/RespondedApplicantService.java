package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.Responded_applicantsDto;

import java.util.List;

public interface RespondedApplicantService {
    List<Responded_applicantsDto> getAllRespond();

    void respondToVacancy(Integer userId, Integer vacancyId, Integer resumeId);

    List<Responded_applicantsDto> getResponsesByApplicant(Integer userId, Integer resumeId);

    List<Responded_applicantsDto> getResponsesByVacancy(Integer userId, Integer vacancyId);
}
