package kg.job.jobsearch.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContactsInfo {
    private Long id;
    private Long type_id;
    private Long resume_id;
    private String contactValue;
}