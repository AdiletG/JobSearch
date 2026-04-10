package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.UserImageDto;
import kg.job.jobsearch.exception.notFoundException.UserImageNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String saveAvatar(MultipartFile file);

    void upload(Long userId, String fileName);

    void upload(UserImageDto imageDto);

    ResponseEntity<?> download(Long userId) throws UserImageNotFoundException;
}
