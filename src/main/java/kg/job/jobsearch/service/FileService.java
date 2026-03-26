package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.UserImageDto;
import kg.job.jobsearch.exception.notFoundException.UserImageNotFoundException;
import org.springframework.http.ResponseEntity;

public interface FileService {
    void upload(UserImageDto userImageDto);

    ResponseEntity<?> download(Long userId) throws UserImageNotFoundException;
}
