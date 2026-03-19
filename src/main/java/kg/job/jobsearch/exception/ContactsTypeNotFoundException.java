package kg.job.jobsearch.exception;

public class ContactsTypeNotFoundException extends NoSuchFieldException{
    public ContactsTypeNotFoundException() {
        super("Contact type not found");
    }

}