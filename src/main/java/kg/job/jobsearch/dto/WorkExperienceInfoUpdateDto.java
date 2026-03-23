package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperienceInfoUpdateDto {
    private Long id;
    private Integer years;
    private String companyName;
    private String position;
    private String responsibilities;
}