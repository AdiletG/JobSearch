package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class ContactsTypeNotFoundException extends NotFoundEntryException {
    public ContactsTypeNotFoundException() {
        super("Contact type not found");
    }
    public ContactsTypeNotFoundException(String message){
        super(message);
    }
}