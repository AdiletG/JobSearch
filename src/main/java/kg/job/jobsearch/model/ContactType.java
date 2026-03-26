package kg.job.jobsearch.model;

import kg.job.jobsearch.enums.ContactTypeEnums;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactType {
    private Long id;
    private ContactTypeEnums type;
}