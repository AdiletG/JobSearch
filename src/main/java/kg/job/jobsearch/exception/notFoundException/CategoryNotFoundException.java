package kg.job.jobsearch.exception.notFoundException;

import kg.job.jobsearch.exception.NotFoundEntryException;

public class CategoryNotFoundException extends NotFoundEntryException {
    public CategoryNotFoundException() {
        super("Category not found");
    }
}
