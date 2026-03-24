package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class VacancyNotFoundException extends NotFoundEntryException {
    public VacancyNotFoundException() {
        super("Vacancy not found");
    }
}
