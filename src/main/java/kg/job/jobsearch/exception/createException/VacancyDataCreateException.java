package kg.job.jobsearch.exception.createException;

import kg.job.jobsearch.exception.DataCreateException;

public class VacancyDataCreateException extends DataCreateException {
    public VacancyDataCreateException() {
        super("Ошибка при создании вакансии");
    }
}