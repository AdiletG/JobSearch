package kg.job.jobsearch.dto.update;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersUpdateDto {
    private Long id;

    @Size(min = 3, max = 15, message = "Имя не можеть быть меньше 3х и больше 15ти")
    @Pattern(regexp = "^[A-Za-zА-Яа-я\\s]+$", message = "Имя не может содержать цифры")
    private String name;

    @Size(min = 5, max = 25, message = "Фамилия не можеть быть меньше 5х и больше 25ти")
    @Pattern(regexp = "^[A-Za-zА-Яа-я\\s]+$", message = "Фамилия не может содержать цифры")
    private String surname;

    @Min(value = 0, message = "Возраст должен быть положительным")
    @Max(value = 150, message = "Возраст не может быть более 150")
    private Integer age;

    @Email(message = "Некорректный email")
    private String email;

    @Pattern(
            regexp = "^$|^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,26}$",
            message = "Пароль должен быть от 6 до 26 символов, содержать заглавную букву и цифру"
    )
    private String password;

    @Pattern(
            regexp = "^$|.{6,26}$",
            message = "Подтверждение должно быть от 6 до 26 символов"
    )
    private String passwordConfirm;
    @Pattern(
            regexp = "^\\+?[0-9\\s]{10,}$",
            message = "Номер телефона должен содержать минимум 10 символов (цифры, пробелы, знак +)"
    )
    private String phoneNumber;

    private MultipartFile avatar;
    private String avatarPath;
}