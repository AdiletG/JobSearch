package kg.job.jobsearch.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespondApplicantCreateDto {
    @NotNull(message = "Для отклика нужно указать какое резюме вы будете использовать")
    private Long resumeId;

    @NotNull(message = "Для отклика нужно указать на какую вакансию вы откликаетесь")
    private Long vacancyId;

    private Boolean confirmation;
}