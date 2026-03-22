package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeCreateDto {
    private String name;
    private BigDecimal salary;
    private Integer categoryId;
    private List<EducationInfoCreateDto> educations;
    private List<WorkExperienceInfoCreateDto> workExperiences;
}