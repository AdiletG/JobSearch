package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class ResumeNotFoundException extends NotFoundEntryException {
    public ResumeNotFoundException() {
        super("Резюме не найдено");
    }
}
