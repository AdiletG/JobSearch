package kg.job.jobsearch.enums;

public enum AccountType {
    EMPLOYER("Работадатель"),
    APPLICANT("Соискатель");

    private final String accountType;

    AccountType(String accountType) {
        this.accountType =  accountType;
    }

    @Override
    public String toString() {
        return accountType;
    }
}
