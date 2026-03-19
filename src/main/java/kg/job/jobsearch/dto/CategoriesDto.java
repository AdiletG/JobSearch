package kg.job.jobsearch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDto {
    private int id;
    private String name;
    private int parentId;

    @Override
    public String toString() {
        return "CategoriesDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent_id=" + parentId +
                '}';
    }
}