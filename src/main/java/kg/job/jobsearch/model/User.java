package kg.job.jobsearch.model;

import jakarta.persistence.*;
import kg.job.jobsearch.enums.AccountTypeEnums;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
    private String phoneNumber;
    private String avatar;
    private AccountTypeEnums accountType;
    private Boolean enabled;

    @OneToMany(mappedBy = "user")
    private List<Resume> resumes;

    @OneToMany(mappedBy = "user")
    private List<Vacancy> vacancies;

    @OneToMany(mappedBy = "user")
    private List<UserImage> userImages;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
}