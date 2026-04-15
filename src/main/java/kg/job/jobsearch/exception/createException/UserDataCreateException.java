package kg.job.jobsearch.exception.createException;


import kg.job.jobsearch.exception.DataCreateException;

public class UserDataCreateException extends DataCreateException {
    public UserDataCreateException() {
        super("Ошибка при создании пользователя");
    }
}
