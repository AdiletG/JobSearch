package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.ContactsInfoDto;
import kg.job.jobsearch.exception.ContactsInfoNotFoundException;
import kg.job.jobsearch.service.ContactsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactsInfoController {
    private final ContactsInfoService contactsInfoService;

    @GetMapping
    public List<ContactsInfoDto> getAllContactsInfo() throws ContactsInfoNotFoundException {
        return contactsInfoService.getAllContactsInfo();
    }
}