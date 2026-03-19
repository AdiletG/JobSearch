package kg.job.jobsearch.exception;

public class MessageNotFoundException extends NoSuchFieldException{
    public MessageNotFoundException() {
        super("Message not found");
    }
}