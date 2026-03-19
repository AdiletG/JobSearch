package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.ContactTypeDto;
import kg.job.jobsearch.exception.ContactsTypeNotFoundException;
import kg.job.jobsearch.model.ContactType;
import kg.job.jobsearch.service.ContactTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact-type")
@RequiredArgsConstructor
public class ContactTypeController {
    private final ContactTypeService contactTypeService;

    @GetMapping
    public List<ContactTypeDto> getAllContactType() throws ContactsTypeNotFoundException {
        return contactTypeService.getAllContactType();
    }
}