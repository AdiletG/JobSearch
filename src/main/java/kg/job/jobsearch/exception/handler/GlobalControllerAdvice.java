package kg.job.jobsearch.exception.handler;

import kg.job.jobsearch.exception.NotFoundEntryException;
import kg.job.jobsearch.service.ErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
public class GlobalControllerAdvice {
    private final ErrorService errorService;

    @ExceptionHandler(NotFoundEntryException.class)
    private ResponseEntity<ErrorResponseBody> noSuchFileExceptionHandler(NotFoundEntryException e) {
        return new ResponseEntity<>(errorService.makeResponse(e, e.getClass().getSimpleName()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    private ResponseEntity<ErrorResponseBody> sqlExceptionHandler(SQLException e) {
        return new ResponseEntity<>(errorService.makeResponse(e, e.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorResponseBody> validationHandler(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(errorService.makeResponse(e.getBindingResult()), HttpStatus.BAD_REQUEST);
    }
}