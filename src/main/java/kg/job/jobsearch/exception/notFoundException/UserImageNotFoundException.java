package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class UserImageNotFoundException extends NotFoundEntryException {
    public UserImageNotFoundException() {
        super("Изображение пользователя не найдено");
    }
}
