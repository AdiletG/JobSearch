package kg.job.jobsearch.exception;

public class CategoryNotFoundException extends NoSuchFieldException{
    public CategoryNotFoundException() {
        super("Category not found");
    }
}
