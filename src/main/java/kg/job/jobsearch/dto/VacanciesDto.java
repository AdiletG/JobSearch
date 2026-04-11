package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacanciesDto {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private BigDecimal salary;
    private Integer expFrom;
    private Integer expTo;
    private Boolean isActive;
    private Long authorId;
    private LocalDate createdDate;
    private LocalDate updateDate;

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