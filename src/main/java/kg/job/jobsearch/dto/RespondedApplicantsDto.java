package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespondedApplicantsDto {
    private Integer id;
    private Integer resumeId;
    private Integer vacancyId;
    private Boolean confirmation;

    @Override
    public String toString() {
        return "Responded_applicantsDto{" +
                "id=" + id +
                ", resume_id=" + resumeId +
                ", vacancy_id=" + vacancyId +
                ", confirmation=" + confirmation +
                '}';
    }
}