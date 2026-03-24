package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class UserNotFoundException extends NotFoundEntryException {
    public UserNotFoundException() {
        super("User not found");
    }
}