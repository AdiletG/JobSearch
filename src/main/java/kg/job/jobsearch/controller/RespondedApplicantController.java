package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.RespondedApplicantsDto;
import kg.job.jobsearch.exception.RespondedApplicantNotFoundException;
import kg.job.jobsearch.service.RespondedApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/respond")
@RequiredArgsConstructor
public class RespondedApplicantController {
    private final RespondedApplicantService respondedApplicantService;

    @GetMapping
    public List<RespondedApplicantsDto> gelAllRespond() throws RespondedApplicantNotFoundException {
        return respondedApplicantService.getAllRespond();
    }
}