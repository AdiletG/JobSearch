package kg.job.jobsearch.model;

import kg.job.jobsearch.enums.AccountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
    private String phone_number;
    private String avatar;
    private AccountType account_type;
}