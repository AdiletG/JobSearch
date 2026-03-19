package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.ContactTypeDao;
import kg.job.jobsearch.dto.ContactTypeDto;
import kg.job.jobsearch.exception.ContactsTypeNotFoundException;
import kg.job.jobsearch.model.ContactType;
import kg.job.jobsearch.service.ContactTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactTypeServiceImpl implements ContactTypeService {
    private final ContactTypeDao contactTypeDao;

    @Override
    public List<ContactTypeDto> getAllContactType() throws ContactsTypeNotFoundException {
        List<ContactType> contactTypes = contactTypeDao.getAllContactsType();
        if(contactTypes.isEmpty()){
            throw new ContactsTypeNotFoundException();
        }

        return contactTypes.stream()
                .map(this::mapToDo)
                .toList();
    }

    private ContactTypeDto mapToDo(ContactType contactType){
        return ContactTypeDto.builder()
                .id(contactType.getId())
                .type(contactType.getType())
                .build();
    }
}