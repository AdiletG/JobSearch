package kg.job.jobsearch.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
@Data
public class VacanciesDto {
    private int id;
    private String name;
    private String description;
    private int category_id;
    private float salary;
    private int exp_from;
    private int exp_to;
    private boolean is_active;
    private int author_id;
    private LocalDateTime created_date;
    private LocalDateTime update_time;
}