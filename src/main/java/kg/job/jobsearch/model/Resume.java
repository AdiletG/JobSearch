package kg.job.jobsearch.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Resume {
    private Integer id;
    private Integer applicant_id;
    private String name;
    private Integer category_id;
    private BigDecimal salary;
    private Boolean is_active;
    private LocalDateTime created_date;
    private LocalDateTime update_time;
}