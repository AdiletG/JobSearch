package kg.job.jobsearch.exception.updateException;

import kg.job.jobsearch.exception.DataUpdateException;

public class ResumeDataUpdateException extends DataUpdateException {
    public ResumeDataUpdateException() {
        super("Ошибка при обновлении резюме");
    }
}
