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

    @NotBlank(message = "Имя обязательно для указания")
    @Size(min = 3, max = 15, message = "Имя не может быть меньше 3х и больше 15ти")
    private String name;

    @Min(value = 0, message = "Зарплата должна быть положительным")
    private BigDecimal salary;

    @NotNull(message = "Категория обязательно для указания")
    @Min(value = 1, message = "Категория должна быть положительным")
    private Long categoryId;

    private Boolean isActive;

    private List<ContactsInfoUpdateDto> contacts;
    private List<EducationInfoUpdateDto> educations;
    private List<WorkExperienceInfoUpdateDto> workExperiences;
}