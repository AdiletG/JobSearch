package kg.job.jobsearch.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Message {
    private Integer id;
    private Integer respondedApplicants;
    private String content;
    private LocalDateTime times;
}