package kg.job.jobsearch.exception.updateException;

import kg.job.jobsearch.exception.DataUpdateException;

public class EducationInfoDataUpdateException extends DataUpdateException {
    public EducationInfoDataUpdateException() {
        super("Ошибка при обновлении информации об образовании");
    }
}
