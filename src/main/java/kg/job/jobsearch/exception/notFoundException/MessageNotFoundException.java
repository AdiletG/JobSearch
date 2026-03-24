package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class MessageNotFoundException extends NotFoundEntryException {
    public MessageNotFoundException() {
        super("Message not found");
    }
}