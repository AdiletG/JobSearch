package kg.job.jobsearch.dto.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespondApplicantUpdateDto {
    private Long id;
    private Long  resumeId;
    private Long vacancyId;
    private Boolean confirmation;
}