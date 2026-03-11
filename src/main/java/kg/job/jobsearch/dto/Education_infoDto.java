package kg.job.jobsearch.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Education_infoDto {
    private int id;
    private int resume_id;
    private String institution;
    private String program;
    private LocalDate start_date;
    private LocalDate end_date;
    private String degree;
}