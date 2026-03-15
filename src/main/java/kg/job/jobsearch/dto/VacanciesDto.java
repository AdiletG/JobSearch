package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacanciesDto {
    private int id;
    private String name;
    private String description;
    private int category_id;
    private float salary;
    private int exp_from;
    private int exp_to;
    private boolean is_active;
    private int author_id;
    private LocalDateTime created_date;
    private LocalDateTime update_time;

    @Override
    public String toString() {
        return "VacanciesDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category_id=" + category_id +
                ", salary=" + salary +
                ", exp_from=" + exp_from +
                ", exp_to=" + exp_to +
                ", is_active=" + is_active +
                ", author_id=" + author_id +
                ", created_date=" + created_date +
                ", update_time=" + update_time +
                '}';
    }
}