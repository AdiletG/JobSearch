package kg.job.jobsearch.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Resume {
    private Long id;
    private Long applicantId;
    private String name;
    private Long categoryId;
    private BigDecimal salary;
    private Boolean isActive;
    private LocalDate createdDate;
    private LocalDate updateDate;
}