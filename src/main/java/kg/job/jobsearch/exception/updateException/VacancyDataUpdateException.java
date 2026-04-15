package kg.job.jobsearch.exception.updateException;

import kg.job.jobsearch.exception.DataUpdateException;

public class VacancyDataUpdateException extends DataUpdateException {
    public VacancyDataUpdateException() {
        super("Ошибка при обновлении вакансии");
    }
}
