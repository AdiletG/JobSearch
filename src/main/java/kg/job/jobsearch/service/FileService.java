package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.UserImageDto;
import kg.job.jobsearch.exception.UserImageNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void upload(UserImageDto userImageDto);

    ResponseEntity<?> download(Long userId) throws UserImageNotFoundException;
}
