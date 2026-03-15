package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Responded_applicantsDto {
    private int id;
    private int resume_id;
    private int vacancy_id;
    private boolean confirmation;

    @Override
    public String toString() {
        return "Responded_applicantsDto{" +
                "id=" + id +
                ", resume_id=" + resume_id +
                ", vacancy_id=" + vacancy_id +
                ", confirmation=" + confirmation +
                '}';
    }
}