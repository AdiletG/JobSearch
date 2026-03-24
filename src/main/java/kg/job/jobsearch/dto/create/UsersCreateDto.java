package kg.job.jobsearch.dto.create;

import jakarta.validation.constraints.*;
import kg.job.jobsearch.enums.AccountTypeEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersCreateDto {
    @NotBlank(message = "Имя обязательно для указания")
    @Size(min = 3, max = 15, message = "Имя не можеть быть меньше 3х и больше 15ти")
    @Pattern(regexp = "^[A-Za-zА-Яа-я\\s]+$", message = "Имя не может содержать цифры")
    private String name;

    @Size(min = 5, max = 25, message = "Фамилия не можеть быть меньше 5х и больше 25ти")
    @Pattern(regexp = "^[A-Za-zА-Яа-я\\s]+$", message = "Фамилия не может содержать цифры")
    private String surname;

    @NotNull(message = "Возраст обязателен")
    @Min(value = 0, message = "Возраст должен быть положительным")
    @Max(value = 150, message = "Возраст не может быть более 150")
    private Integer age;

    @NotBlank(message = "Email должен быть заполнен")
    @Email(message = "Некорректный email")
    private String email;

    @NotBlank
    @Size(
            min = 6,
            max = 26,
            message = "Длина пароля должна быть >= 6 и <= 26"
    )
    @Pattern(
            regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).+$",
            message = "Содержит как минимум одну заглавную букву и одну цифру"
    )
    private String password;

    @Pattern(
            regexp = "^\\+?[0-9\\s]{10,}$",
            message = "Номер телефона должен содержать минимум 10 символов (цифры, пробелы, знак +)"
    )
    private String phoneNumber;

    private String avatar;

    @NotNull(message = "Тип аккаунта обязателен")
    private AccountTypeEnums accountType;

}