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
@Table(name = "resumes")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private User applicant;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private BigDecimal salary;
    private Boolean isActive;

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

    @OneToMany(mappedBy = "resume")
    private List<ContactsInfo> contacts;

    @OneToMany(mappedBy = "resume")
    private List<EducationInfo> educations;

    @OneToMany(mappedBy = "resume")
    private List<RespondedApplicant> respondedApplicants;

    @OneToMany(mappedBy = "resume")
    private List<WorkExperienceInfo> workExperienceInfos;
}