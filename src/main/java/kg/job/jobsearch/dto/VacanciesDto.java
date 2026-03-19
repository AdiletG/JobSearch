package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacanciesDto {
    private Integer id;
    private String name;
    private String description;
    private Integer categoryId;
    private BigDecimal salary;
    private Integer expFrom;
    private Integer expTo;
    private Boolean isActive;
    private Integer authorId;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

    @Override
    public String toString() {
        return "VacanciesDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", salary=" + salary +
                ", expFrom=" + expFrom +
                ", expTo=" + expTo +
                ", isActive=" + isActive +
                ", authorId=" + authorId +
                ", createdDate=" + createdDate +
                ", updateTime=" + updateDate +
                '}';
    }
}