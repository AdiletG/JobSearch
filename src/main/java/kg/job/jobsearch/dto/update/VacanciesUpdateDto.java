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
    private Long id;

    @NotBlank(message = "Названия обязательно для указания")
    @Size(min = 5, max = 25, message = "Названия не может быть меньше 5х и больше 25ти")
    private String name;

    @Size(max = 500, message = "Описание не может быть длиннее 500 символов")
    private String description;

    @NotNull(message = "Категория обязательно для указания")
    @Min(value = 1, message = "Категория должна быть положительным")
    private Long categoryId;

    @Min(value = 0, message = "Зарплата должна быть положительным")
    private BigDecimal salary;

    @Min(value = 0, message = "Опыт работы должен быть положительным")
    private Integer expFrom;

    @Min(value = 0, message = "Опыт работы должен быть положительным")
    private Integer expTo;

    private Boolean isActive;
}