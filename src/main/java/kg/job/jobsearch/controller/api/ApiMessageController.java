package kg.job.jobsearch.controller.api;

import kg.job.jobsearch.dto.MessagesDto;
import kg.job.jobsearch.exception.notFoundException.MessageNotFoundException;
import kg.job.jobsearch.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class ApiMessageController {
    private final MessagesService messagesService;

    @GetMapping
    public List<MessagesDto> getAllMessages() throws MessageNotFoundException {
        return messagesService.getAllMessage();
    }
}