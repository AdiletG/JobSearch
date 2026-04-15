package kg.job.jobsearch.dto.create;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumeCreateDto {

    @NotBlank(message = "Имя обязательно для указания")
    @Size(min = 3, max = 15, message = "Имя не можеть быть меньше 3х и больше 15ти")
    @Pattern(regexp = "^[A-Za-zА-Яа-я\\s]+$", message = "Имя не может содержать цифры")
    private String name;

    @Min(value = 0, message = "Зарплата должна быть положительным")
    private BigDecimal salary;

    @NotNull
    @Min(value = 0, message = "Категория должна быть положительным")
    private Long categoryId;

    private List<ContactsInfoCreateDto> contacts = new ArrayList<>();
    private List<EducationInfoCreateDto> educations = new ArrayList<>();
    private List<WorkExperienceInfoCreateDto> workExperiences = new ArrayList<>();
}