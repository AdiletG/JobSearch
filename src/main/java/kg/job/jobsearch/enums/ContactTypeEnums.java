package kg.job.jobsearch.enums;

public enum ContactTypeEnums {
    TELEGRAM("Телеграм"),
    EMAIL("Почта"),
    PHONE_NUMBER("Phone-number");

    private final String contactType;

    ContactTypeEnums(String contactType) {
        this.contactType = contactType;
    }

    @Override
    public String toString() {
        return "ContactType: " + contactType;
    }
}
