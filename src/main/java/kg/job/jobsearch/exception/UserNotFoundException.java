package kg.job.jobsearch.exception;

public class UserNotFoundException extends NoSuchFieldException{
    public UserNotFoundException() {
        super("User not found");
    }
}