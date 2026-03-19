package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.ContactTypeDto;
import kg.job.jobsearch.exception.ContactsTypeNotFoundException;

import java.util.List;

public interface ContactTypeService {
    List<ContactTypeDto> getAllContactType() throws ContactsTypeNotFoundException;
}
