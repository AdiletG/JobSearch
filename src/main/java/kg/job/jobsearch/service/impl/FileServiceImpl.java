package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;
@Service
public class FileServiceImpl implements FileService {

    private static final String UPLOAD_DIR = "data/";

    private String saveUploadFile(MultipartFile file, String subdir) throws IOException {

        String uuid = UUID.randomUUID().toString();
        String resultFilename = uuid + "_" + file.getOriginalFilename();

        Path pathDir = Path.of(UPLOAD_DIR, subdir);
        Files.createDirectories(pathDir);

        Path filePath = pathDir.resolve(resultFilename);

        Files.copy(file.getInputStream(), filePath);

        return resultFilename;
    }

    @Override
    public String upload(MultipartFile file) {

        try {
            return saveUploadFile(file, "images");
        } catch (IOException e) {
            e.printStackTrace();
            return "Ошибка загрузки файла";

        }
    }
}