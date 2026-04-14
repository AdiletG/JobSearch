package kg.job.jobsearch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    private Long id;

    @Column(name = "authority")
    private String authorityName;

    @ManyToMany(mappedBy = "authorities")
    private List<Role> roles;
}