package kg.job.jobsearch.model;

import jakarta.persistence.*;
import kg.job.jobsearch.enums.ContactTypeEnums;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "contact_types")
public class ContactType {
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ContactTypeEnums type;
}