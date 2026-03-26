package kg.job.jobsearch.dto.update;

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
public class VacanciesUpdateDto {
    @NotBlank(message = "Названия обязательно для указания")
    @Size(min = 5, max = 25, message = "Названия не можеть быть меньше 5х и больше 25ти")
    @Pattern(regexp = "^[A-Za-zА-Яа-я\\s]+$", message = "Названия не может содержать цифры")
    private String name;

    @Pattern(regexp = "^[A-Za-zА-Яа-я\\s]+$", message = "Описание не может содержать цифры")
    private String description;

    @NotNull
    @NotBlank(message = "Категория обязательно для указания")
    @Min(value = 0, message = "Категория должна быть положительным")
    private Long categoryId;

    @Min(value = 0, message = "Зарплата должна быть положительным")
    private BigDecimal salary;

    @Min(value = 0, message = "Опыт работы должен быть положительным")
    private Integer expFrom;

    @Min(value = 0, message = "Опыт работы должен быть положительным")
    private Integer expTo;

    @NotBlank(message = "Активность вакансии обязательно для указания")
    private Boolean isActive;
}