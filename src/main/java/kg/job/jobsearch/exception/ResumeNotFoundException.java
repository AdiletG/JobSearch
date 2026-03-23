package kg.job.jobsearch.exception;

public class ResumeNotFoundException extends NoSuchFieldException{
    public ResumeNotFoundException() {
        super("Resume not found");
    }

    public ResumeNotFoundException(String message){
        super(message);
    }
}
