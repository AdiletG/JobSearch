package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.ContactsInfoDto;
import kg.job.jobsearch.exception.notFoundException.ContactsInfoNotFoundException;
import kg.job.jobsearch.model.ContactsInfo;
import kg.job.jobsearch.repository.ContactInfoRepository;
import kg.job.jobsearch.service.ContactsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactsInfoServiceImpl implements ContactsInfoService {
    private final ContactInfoRepository contactInfoRepository;

    @Override
    public List<ContactsInfoDto> getAllContactsInfo() throws ContactsInfoNotFoundException {
        List<ContactsInfo> contactsInfos = contactInfoRepository.findAll();
        if(contactsInfos.isEmpty()){
            throw new ContactsInfoNotFoundException();
        }

        return contactsInfos.stream()
                .map(this::mapToDto)
                .toList();
    }

    private ContactsInfoDto mapToDto(ContactsInfo contactsInfo) {
        return ContactsInfoDto.builder()
                .id(contactsInfo.getId())
                .type_id(contactsInfo.getType().getId())
                .resume_id(contactsInfo.getResume().getId())
                .contactValue(contactsInfo.getContactValue())
                .build();
    }
}