package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumesDto {
    private Integer id;
    private Integer applicant_id;
    private String name;
    private Integer category_id;
    private BigDecimal salary;
    private Boolean is_active;
    private LocalDateTime created_date;
    private LocalDateTime update_time;

    @Override
    public String toString() {
        return "ResumesDto{" +
                "id=" + id +
                ", applicant_id=" + applicant_id +
                ", name='" + name + '\'' +
                ", category_id=" + category_id +
                ", salary=" + salary +
                ", is_active=" + is_active +
                ", created_date=" + created_date +
                ", update_time=" + update_time +
                '}';
    }
}