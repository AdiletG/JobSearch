package kg.job.jobsearch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    private List<Resume> resumes;

    @OneToMany(mappedBy = "category")
    private List<Vacancy> vacancies;
}