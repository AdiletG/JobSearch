package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.UserImageDao;
import kg.job.jobsearch.dto.UserImageDto;
import kg.job.jobsearch.exception.notFoundException.UserImageNotFoundException;
import kg.job.jobsearch.model.UserImage;
import kg.job.jobsearch.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final UserImageDao userImageDao;
    private static final String UPLOAD_DIR = "data/";

    @Override
    public String saveAvatar(MultipartFile file) {
        return saveUploadedFile(file, "images");
    }

    @SneakyThrows
    private String saveUploadedFile(MultipartFile file, String subdir) {
        String uuid = UUID.randomUUID().toString();
        String resultFilename = uuid + "_" + file.getOriginalFilename();

        Path pathDir = Paths.get(UPLOAD_DIR + subdir); // data/images
        if (!Files.exists(pathDir)) Files.createDirectories(pathDir);

        Path filePath = pathDir.resolve(resultFilename);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        try (OutputStream os = Files.newOutputStream(filePath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultFilename;
    }


    private byte[] getDownloadedFile(String filename, String subdir) throws IOException {
        return Files.readAllBytes(Paths.get(UPLOAD_DIR + subdir + "/" + filename));
    }

    @Override
    public void upload(Long userId, String fileName) {

        log.debug("Result filename uploaded image is {}", fileName);

        userImageDao.save(userId, fileName);
    }

    @Override
    public void upload(UserImageDto imageDto) {
        String fileName = saveUploadedFile(imageDto.getFile(), "image");
        log.debug("Result filename uploaded image is {}", fileName);

        userImageDao.save(imageDto.getUserId(), fileName);
    }

    @Override
    public ResponseEntity<?> download(Long userId) throws UserImageNotFoundException {
        UserImage userImage = userImageDao.findByUserId(userId)
                .orElseThrow(UserImageNotFoundException::new);
        log.debug("UserId = {}, image filename = {}", userImage.getUserId(), userImage.getFilename());
        try {
            ByteArrayResource resource = new ByteArrayResource(getDownloadedFile(userImage.getFilename(), "images"));

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + userImage.getFilename() + "\"")
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(resource);
        } catch (IOException e) {
            log.error(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Image not found");
        }
    }
}