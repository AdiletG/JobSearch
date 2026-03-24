package kg.job.jobsearch.dto.update;

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
public class ResumeUpdateDto {
    private String name;
    private BigDecimal salary;
    private Long categoryId;
    private List<ContactsInfoUpdateDto> contacts;
    private List<EducationInfoUpdateDto> educations;
    private List<WorkExperienceInfoUpdateDto> workExperiences;
}