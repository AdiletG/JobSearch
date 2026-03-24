package kg.job.jobsearch.enums;

public enum AccountTypeEnums {
    EMPLOYER("Работодатель"),
    APPLICANT("Соискатель");

    private final String accountType;

    AccountTypeEnums(String accountType) {
        this.accountType =  accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
