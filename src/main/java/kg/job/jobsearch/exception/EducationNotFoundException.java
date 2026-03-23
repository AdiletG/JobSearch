package kg.job.jobsearch.exception;

public class EducationNotFoundException extends NoSuchFieldException{
    public EducationNotFoundException() {
        super("Education information not found");
    }
    public EducationNotFoundException(String message){
        super(message);
    }

}