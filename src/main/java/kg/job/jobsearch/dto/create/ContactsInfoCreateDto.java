package kg.job.jobsearch.dto.create;

import jakarta.validation.constraints.NotNull;
import kg.job.jobsearch.model.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactsInfoCreateDto {
    private Long type_id;

    @NotNull(message = "Контакт обязателен")
    private String contactValue;
}