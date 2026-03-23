package kg.job.jobsearch.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Message {
    private Long id;
    private Long respondedApplicants;
    private String content;
    private LocalDateTime times;
}