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

    @NotBlank(message = "Название вакансии обязательно")
    @Size(min = 5, max = 100, message = "Название должно быть от 5 до 100 символов")
    private String name;

    @Size(max = 2000, message = "Описание слишком длинное (макс. 2000 символов)")
    private String description;

    @NotNull(message = "Категория обязательно должна быть выбрана")
    @Min(value = 1, message = "Некорректный ID категории")
    private Long categoryId;

    @Min(value = 0, message = "Зарплата не может быть отрицательной")
    private BigDecimal salary;

    @Min(value = 0, message = "Опыт работы 'от' не может быть отрицательным")
    private Integer expFrom;

    @Min(value = 0, message = "Опыт работы 'до' не может быть отрицательным")
    private Integer expTo;

    private Boolean isActive;
}