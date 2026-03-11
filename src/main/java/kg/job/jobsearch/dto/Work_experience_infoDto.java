package kg.job.jobsearch.dto;

import lombok.Data;

@Data
public class Work_experience_infoDto {
    private int id;
    private int resume_id;
    private int years;
    private String company_name;
    private String position;
    private String responsibilities;
}