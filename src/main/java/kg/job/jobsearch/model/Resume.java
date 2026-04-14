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
@Table(name = "resumes")
public class Resume {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private User user;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private BigDecimal salary;
    private Boolean isActive;
    private LocalDate createdDate;
    private LocalDate updateDate;

    @OneToMany(mappedBy = "resume")
    private List<ContactsInfo> contacts;

    @OneToMany(mappedBy = "resume")
    private List<EducationInfo> educations;

    @OneToMany(mappedBy = "resume")
    private List<RespondedApplicant> respondedApplicants;

    @OneToMany(mappedBy = "resume")
    private List<WorkExperienceInfo> workExperienceInfos;
}