package kg.job.jobsearch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Lob
    @Column(name = "description")
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
    private User author;

    @Column(name = "created_date", updatable = false)
    private LocalDate createdDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @PrePersist
    protected void onCreate() {
        if (this.createdDate == null) this.createdDate = LocalDate.now();
        if (this.updateDate == null) this.updateDate = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateDate = LocalDate.now();
    }

    @OneToMany(mappedBy = "vacancy")
    private List<RespondedApplicant> respondedApplicants;
}