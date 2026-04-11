package kg.job.jobsearch.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Vacancy {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private BigDecimal salary;
    private Integer expFrom;
    private Integer expTo;
    private Boolean isActive;
    private Long authorId;
    private LocalDate createdDate;
    private LocalDate updateDate;
}