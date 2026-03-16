package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.Responded_applicantsDto;
import kg.job.jobsearch.service.RespondedApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Responded_applicantsDto>> getAllRespond(){
        return ResponseEntity.ok(respondedApplicantService.getAllRespond());
    }
}