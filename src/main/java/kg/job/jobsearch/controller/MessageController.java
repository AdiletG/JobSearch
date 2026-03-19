package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.MessagesDto;
import kg.job.jobsearch.exception.MessageNotFoundException;
import kg.job.jobsearch.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessagesService messagesService;

    @GetMapping
    public List<MessagesDto> getAllMessages() throws MessageNotFoundException {
        return messagesService.getAllMessage();
    }
}