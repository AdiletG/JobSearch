package kg.job.jobsearch.exception;

public class ContactsInfoNotFoundException extends NoSuchFieldException{
    public ContactsInfoNotFoundException() {
        super("Contact info not found");
    }
    public ContactsInfoNotFoundException(String message){
        super(message);
    }
}
