package kg.job.jobsearch.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContactsInfo {
    private Integer id;
    private Integer type_id;
    private Integer resume_id;
    private String contactValue;
}