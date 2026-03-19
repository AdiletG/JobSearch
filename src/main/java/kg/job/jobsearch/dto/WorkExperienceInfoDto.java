package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkExperienceInfoDto {
    private Integer id;
    private Integer resumeId;
    private Integer years;
    private String companyName;
    private String position;
    private String responsibilities;

    @Override
    public String toString() {
        return "WorkExperienceInfoDto{" +
                "id=" + id +
                ", resumeId=" + resumeId +
                ", years=" + years +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                '}';
    }
}