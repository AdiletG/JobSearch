package kg.job.jobsearch.service;


import kg.job.jobsearch.dto.RespondedApplicantsDto;
import kg.job.jobsearch.exception.notFoundException.RespondedApplicantNotFoundException;

import java.util.List;

public interface RespondedApplicantService {

    List<RespondedApplicantsDto> getAllRespond() throws RespondedApplicantNotFoundException;
}
