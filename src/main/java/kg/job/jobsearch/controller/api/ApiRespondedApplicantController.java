package kg.job.jobsearch.controller.api;

import kg.job.jobsearch.dto.RespondedApplicantsDto;
import kg.job.jobsearch.exception.notFoundException.RespondedApplicantNotFoundException;
import kg.job.jobsearch.service.RespondedApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/respond")
@RequiredArgsConstructor
public class ApiRespondedApplicantController {
    private final RespondedApplicantService respondedApplicantService;

    @GetMapping
    public List<RespondedApplicantsDto> gelAllRespond() throws RespondedApplicantNotFoundException {
        return respondedApplicantService.getAllRespond();
    }
}