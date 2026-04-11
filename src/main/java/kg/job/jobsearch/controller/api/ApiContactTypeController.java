package kg.job.jobsearch.controller.api;

import kg.job.jobsearch.dto.ContactTypesDto;
import kg.job.jobsearch.exception.notFoundException.ContactsTypeNotFoundException;
import kg.job.jobsearch.service.ContactTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/contact-type")
@RequiredArgsConstructor
public class ApiContactTypeController {
    private final ContactTypeService contactTypeService;

    @GetMapping
    public List<ContactTypesDto> getAllContactType() throws ContactsTypeNotFoundException {
        return contactTypeService.getAllContactType();
    }
}