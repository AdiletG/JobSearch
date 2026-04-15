package kg.job.jobsearch.exception.createException;

import kg.job.jobsearch.exception.DataCreateException;

public class ResumeDataCreateException extends DataCreateException {
    public ResumeDataCreateException() {
        super("Ошибка при создании резюме");
    }
}
