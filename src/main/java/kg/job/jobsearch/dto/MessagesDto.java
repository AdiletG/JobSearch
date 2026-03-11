package kg.job.jobsearch.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessagesDto {
    private int id;
    private int responded_applicants;
    private String content;
    private LocalDateTime timestamp;
}