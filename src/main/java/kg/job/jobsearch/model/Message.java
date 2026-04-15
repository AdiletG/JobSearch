package kg.job.jobsearch.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "responded_applicants_id")
    private RespondedApplicant respondedApplicant;

    private String content;
    private LocalDateTime times;
}