package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.ContactTypesDto;
import kg.job.jobsearch.exception.notFoundException.ContactsTypeNotFoundException;

import java.util.List;

public interface ContactTypeService {
    List<ContactTypesDto> getAllContactType() throws ContactsTypeNotFoundException;
}
