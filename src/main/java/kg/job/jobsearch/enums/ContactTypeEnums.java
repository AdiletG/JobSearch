package kg.job.jobsearch.enums;

public enum ContactTypeEnums {
    TELEGRAM("Telegram"),
    EMAIL("Email"),
    PHONE_NUMBER("PHONE_NUMBER");

    private final String contactType;

    ContactTypeEnums(String contactType) {
        this.contactType = contactType;
    }

    public static ContactTypeEnums fromDbValue(String value) {
        for (ContactTypeEnums type : values()) {
            if (type.name().equalsIgnoreCase(value) || type.contactType.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown contact type: " + value);
    }

    @Override
    public String toString() {
        return contactType;
    }
}
