package kg.job.jobsearch.exception.NoAccessException;

public class NoAccessException extends RuntimeException {
    public NoAccessException(String message) {
        super(message);
    }

    public NoAccessException() {
        super("У вас недостаточно прав для выполнения этого действия");
    }
}
