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
public class ResumesDto {
    private Long id;
    private Long applicantId;
    private String name;
    private Long categoryId;
    private BigDecimal salary;
    private Boolean isActive;
    private LocalDate createdDate;
    private LocalDate updateDate;

    @Override
    public String toString() {
        return "ResumesDto{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", salary=" + salary +
                ", isActive=" + isActive +
                ", createdDate=" + createdDate +
                ", updateDime=" + updateDate +
                '}';
    }
}