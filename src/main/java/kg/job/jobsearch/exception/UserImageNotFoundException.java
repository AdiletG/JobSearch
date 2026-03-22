package kg.job.jobsearch.exception;

public class UserImageNotFoundException extends NoSuchFieldException{
    public UserImageNotFoundException() {
        super("Resume not found");
    }
}
