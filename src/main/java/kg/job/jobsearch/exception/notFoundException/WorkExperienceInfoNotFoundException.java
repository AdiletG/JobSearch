package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class WorkExperienceInfoNotFoundException  extends NotFoundEntryException {
    public WorkExperienceInfoNotFoundException() {
        super("Опыт работы не найден");
    }
}
