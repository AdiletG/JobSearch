package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class EducationNotFoundException extends NotFoundEntryException {
    public EducationNotFoundException() {
        super("Информация об образовании не найдена");
    }
}