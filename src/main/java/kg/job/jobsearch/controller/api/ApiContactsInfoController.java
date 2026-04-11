package kg.job.jobsearch.controller.api;

import kg.job.jobsearch.dto.ContactsInfoDto;
import kg.job.jobsearch.exception.notFoundException.ContactsInfoNotFoundException;
import kg.job.jobsearch.service.ContactsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/contacts")
@RequiredArgsConstructor
public class ApiContactsInfoController {
    private final ContactsInfoService contactsInfoService;

    @GetMapping
    public List<ContactsInfoDto> getAllContactsInfo() throws ContactsInfoNotFoundException {
        return contactsInfoService.getAllContactsInfo();
    }
}