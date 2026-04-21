package kg.job.jobsearch.model;

import jakarta.persistence.*;
import kg.job.jobsearch.enums.AccountTypeEnums;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
    private String phoneNumber;

    @Column(name = "avatar", columnDefinition = "CLOB")
    private String avatar;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountTypeEnums accountType;

    private Boolean enabled;

    @OneToMany(mappedBy = "applicant")
    private List<Resume> resumes;

    @OneToMany(mappedBy = "author")
    private List<Vacancy> vacancies;

    @OneToMany(mappedBy = "user")
    private List<UserImage> userImages;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("FULL"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}