package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessagesDto {
    private Long id;
    private Long respondedApplicants;
    private String content;
    private LocalDateTime sent_at;

    @Override
    public String toString() {
        return "MessagesDto{" +
                "id=" + id +
                ", responded_applicants=" + respondedApplicants +
                ", content='" + content + '\'' +
                ", sent_at=" + sent_at +
                '}';
    }
}