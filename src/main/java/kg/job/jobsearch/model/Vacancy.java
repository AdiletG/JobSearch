package kg.job.jobsearch.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Vacancy {
    private Integer id;
    private String name;
    private String description;
    private Integer category_id;
    private BigDecimal salary;
    private Integer exp_from;
    private Integer exp_to;
    private Boolean is_active;
    private Integer author_id;
    private LocalDateTime created_date;
    private LocalDateTime update_time;
}