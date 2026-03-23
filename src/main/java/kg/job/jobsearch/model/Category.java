package kg.job.jobsearch.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {
    private Long id;
    private String name;
    private Long parentId;
}