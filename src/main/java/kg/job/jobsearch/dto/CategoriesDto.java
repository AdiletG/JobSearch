package kg.job.jobsearch.dto;

import lombok.Data;

@Data
public class CategoriesDto {
    private int id;
    private String name;
    private int parent_id;
}