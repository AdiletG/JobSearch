package kg.job.jobsearch.service;

import kg.job.jobsearch.exception.handler.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {
    ErrorResponseBody makeResponse(Exception e, String exceptionClass);

    ErrorResponseBody makeResponse(BindingResult bindingResult);
}
