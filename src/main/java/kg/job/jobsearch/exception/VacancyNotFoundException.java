package kg.job.jobsearch.exception;

public class VacancyNotFoundException extends NoSuchFieldException{
    public VacancyNotFoundException() {
        super("Vacancy not found");
    }
}
