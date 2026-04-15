package kg.job.jobsearch.exception.updateException;

import kg.job.jobsearch.exception.DataUpdateException;

public class ContactInfoDataUpdateException extends DataUpdateException {
    public ContactInfoDataUpdateException() {
        super("Ошибка при обновлении контактной информации");
    }
}
