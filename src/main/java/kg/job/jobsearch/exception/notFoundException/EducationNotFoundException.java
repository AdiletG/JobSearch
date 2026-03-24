package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class EducationNotFoundException extends NotFoundEntryException {
    public EducationNotFoundException() {
        super("Education information not found");
    }
    public EducationNotFoundException(String message){
        super(message);
    }

}