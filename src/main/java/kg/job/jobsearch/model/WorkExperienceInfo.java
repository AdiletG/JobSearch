package kg.job.jobsearch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "work_experience_info")
public class WorkExperienceInfo {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    private Integer years;
    private String companyName;
    private String position;
    private String responsibilities;
}