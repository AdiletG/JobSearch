package kg.job.jobsearch.exception;

public class VacancyNotFoundException extends NoSuchFieldException{
    public VacancyNotFoundException() {
        super("User not found");
    }
}
