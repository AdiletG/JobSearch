package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class ContactsInfoNotFoundException extends NotFoundEntryException {
    public ContactsInfoNotFoundException() {
        super("Контактная информация не найдена");
    }
}
