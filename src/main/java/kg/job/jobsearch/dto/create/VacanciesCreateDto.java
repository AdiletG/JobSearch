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

    @NotBlank(message = "Название обязательно для заполнения")
    @Size(min = 5, max = 50, message = "Название должно быть от 5 до 50 символов")
    private String name;

    @NotBlank(message = "Описание обязательно для заполнения")
    @Size(min = 10, message = "Описание должно быть более подробным (от 10 символов)")
    private String description;

    @NotNull(message = "Категория обязательна для указания")
    @Min(value = 1, message = "Выберите корректную категорию")
    private Long categoryId;

    @NotNull(message = "Укажите зарплату")
    @DecimalMin(value = "0.0", inclusive = true, message = "Зарплата не может быть отрицательной")
    private BigDecimal salary;

    @NotNull(message = "Укажите минимальный опыт")
    @Min(value = 0, message = "Опыт работы не может быть отрицательным")
    private Integer expFrom;

    @NotNull(message = "Укажите максимальный опыт")
    @Min(value = 0, message = "Опыт работы не может быть отрицательным")
    private Integer expTo;
}