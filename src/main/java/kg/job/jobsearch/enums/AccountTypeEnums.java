package kg.job.jobsearch.enums;

import lombok.Getter;

@Getter
public enum AccountTypeEnums {
    EMPLOYER("Работодатель"),
    APPLICANT("Соискатель"),
    ADMIN("ADMIN");

    private final String accountType;

    AccountTypeEnums(String accountType) {
        this.accountType =  accountType;
    }

}
