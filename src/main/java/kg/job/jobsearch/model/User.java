package kg.job.jobsearch.model;

import kg.job.jobsearch.enums.AccountTypeEnums;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;
    private String phoneNumber;
    private String avatar;
    private AccountTypeEnums accountType;
}