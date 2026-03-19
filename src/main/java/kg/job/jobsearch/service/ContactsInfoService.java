package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.ContactsInfoDto;
import kg.job.jobsearch.exception.ContactsInfoNotFoundException;

import java.util.List;

public interface ContactsInfoService {
    List<ContactsInfoDto> getAllContactsInfo() throws ContactsInfoNotFoundException;
}
