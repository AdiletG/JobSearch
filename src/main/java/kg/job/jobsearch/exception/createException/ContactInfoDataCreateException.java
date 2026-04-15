package kg.job.jobsearch.exception.createException;

import kg.job.jobsearch.exception.DataCreateException;

public class ContactInfoDataCreateException extends DataCreateException {
    public ContactInfoDataCreateException() {
        super("Ошибка при создании контактов");
    }
}
