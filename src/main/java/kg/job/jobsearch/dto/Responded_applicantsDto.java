package kg.job.jobsearch.dto;

import lombok.Data;

@Data
public class Responded_applicantsDto {
    private int id;
    private int resume_id;
    private int vacancy_id;
    private boolean confirmation;
}