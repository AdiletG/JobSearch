package kg.job.jobsearch.dto.update;

import jakarta.validation.constraints.*;
import kg.job.jobsearch.dto.create.ContactsInfoCreateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeUpdateDto {
    private Long id;

    @NotBlank(message = "Имя обязательно для заполнения")
    @Size(min = 3, max = 50, message = "Имя должно быть от 3 до 50 символов")
    private String name;

    @Min(value = 0, message = "Зарплата не может быть отрицательной")
    private BigDecimal salary;

    @NotNull(message = "Категория должна быть указана")
    @Min(value = 1, message = "Некорректный ID категории")
    private Long categoryId;

    private Boolean isActive;

    private List<ContactsInfoUpdateDto> contacts;
    private List<EducationInfoUpdateDto> educations;
    private List<WorkExperienceInfoUpdateDto> workExperiences;
}