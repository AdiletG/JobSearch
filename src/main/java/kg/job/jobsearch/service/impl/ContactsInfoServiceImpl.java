package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.ContactsInfoDao;
import kg.job.jobsearch.dto.ContactsInfoDto;
import kg.job.jobsearch.exception.notFoundException.ContactsInfoNotFoundException;
import kg.job.jobsearch.model.ContactsInfo;
import kg.job.jobsearch.service.ContactsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactsInfoServiceImpl implements ContactsInfoService {
    private final ContactsInfoDao contactsInfoDao;

    @Override
    public List<ContactsInfoDto> getAllContactsInfo() throws ContactsInfoNotFoundException {
        List<ContactsInfo> contactsInfos = contactsInfoDao.getAllContactsInfo();
        if(contactsInfos.isEmpty()){
            throw new ContactsInfoNotFoundException();
        }

        return contactsInfos.stream()
                .map(this::mapToDo)
                .toList();
    }

    private ContactsInfoDto mapToDo(ContactsInfo contactsInfo){
        return ContactsInfoDto.builder()
                .id(contactsInfo.getId())
                .type_id(contactsInfo.getType_id())
                .resume_id(contactsInfo.getResume_id())
                .contactValue(contactsInfo.getContactValue())
                .build();
    }
}