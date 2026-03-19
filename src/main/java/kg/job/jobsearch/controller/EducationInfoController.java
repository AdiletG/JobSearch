package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.EducationInfoDto;
import kg.job.jobsearch.exception.EducationNotFoundException;
import kg.job.jobsearch.service.EducationInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/education")
@RequiredArgsConstructor
public class EducationInfoController {
    private final EducationInfoService educationInfoService;

    @GetMapping
    public List<EducationInfoDto> getAllEducation() throws EducationNotFoundException {
        return educationInfoService.getAllEducationInfo();
    }
}