package kg.job.jobsearch.exception.notFoundException;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserNameNotFoundException extends UsernameNotFoundException {
    public UserNameNotFoundException() {
        super("User not found");
    }
}
