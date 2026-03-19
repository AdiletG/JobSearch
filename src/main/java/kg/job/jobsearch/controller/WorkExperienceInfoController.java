package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.WorkExperienceInfoDto;
import kg.job.jobsearch.exception.WorkExperienceInfoNotFoundException;
import kg.job.jobsearch.model.WorkExperienceInfo;
import kg.job.jobsearch.service.WorkExperienceInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/experience")
@RequiredArgsConstructor
public class WorkExperienceInfoController {
    private final WorkExperienceInfoService workExperienceInfoService;

    @GetMapping
    public List<WorkExperienceInfoDto> getAllWorkExperienceInfo() throws WorkExperienceInfoNotFoundException {
        return workExperienceInfoService.getAllWorkExperienceInfo();
    }
}