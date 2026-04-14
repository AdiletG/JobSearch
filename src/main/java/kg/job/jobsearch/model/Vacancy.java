package kg.job.jobsearch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Vacancies")
public class Vacancy {
    @Id
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private BigDecimal salary;
    private Integer expFrom;
    private Integer expTo;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;

    private LocalDate createdDate;
    private LocalDate updateDate;

    @OneToMany(mappedBy = "vacancy")
    private List<RespondedApplicant> respondedApplicants;
}