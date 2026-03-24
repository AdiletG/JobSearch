package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class WorkExperienceInfoNotFoundException  extends NotFoundEntryException {
    public WorkExperienceInfoNotFoundException() {
        super("Work experience info not found");
    }
    public WorkExperienceInfoNotFoundException(String message){
        super(message);
    }
}
