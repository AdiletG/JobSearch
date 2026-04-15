package kg.job.jobsearch.exception.updateException;

import kg.job.jobsearch.exception.DataUpdateException;

public class UserDataUpdateException extends DataUpdateException {
    public UserDataUpdateException() {
        super("Ошибка при обновлении данных пользователя");
    }
}
