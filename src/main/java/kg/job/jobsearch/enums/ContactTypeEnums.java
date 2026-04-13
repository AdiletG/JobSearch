package kg.job.jobsearch.enums;

public enum ContactTypeEnums {
    TELEGRAM("Телеграм"),
    EMAIL("Почта"),
    PHONE_NUMBER("Phone-number");

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
