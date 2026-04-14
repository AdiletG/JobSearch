package kg.job.jobsearch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "contacts_info")
public class ContactsInfo {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ContactType type;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Column(name = "contact_value")
    private String contactValue;
}