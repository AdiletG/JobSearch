package kg.job.jobsearch.dto.create;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacanciesCreateDto {

    @NotBlank(message = "Названия обязательно для указания")
    @Size(min = 5, max = 25, message = "Названия не можеть быть меньше 5х и больше 25ти")
    @Pattern(regexp = "^[A-Za-zА-Яа-я\\s]+$", message = "Названия не может содержать цифры")
    private String name;

    @Pattern(regexp = "^[A-Za-zА-Яа-я\\s]+$", message = "Описание не может содержать цифры")
    private String description;

    @NotNull(message = "Категория обязательна для указания")
    @Min(value = 1, message = "Выберите категорию")
    private Long categoryId;

    @Min(value = 0, message = "Зарплата должна быть положительным")
    private BigDecimal salary;

    @Min(value = 0, message = "Опыт работы должен быть положительным")
    private Integer expFrom;

    @Min(value = 0, message = "Опыт работы должен быть положительным")
    private Integer expTo;
}