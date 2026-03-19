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
    private Integer applicantId;
    private String name;
    private Integer categoryId;
    private BigDecimal salary;
    private Boolean isActive;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

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