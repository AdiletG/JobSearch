package kg.job.jobsearch.exception;

public class WorkExperienceInfoNotFoundException  extends NoSuchFieldException{
    public WorkExperienceInfoNotFoundException() {
        super("Work experience info not found");
    }
}
