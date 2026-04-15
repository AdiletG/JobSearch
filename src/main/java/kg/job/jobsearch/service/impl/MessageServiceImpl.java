package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.MessagesDto;
import kg.job.jobsearch.exception.notFoundException.MessageNotFoundException;
import kg.job.jobsearch.model.Message;
import kg.job.jobsearch.repository.MessageRepository;
import kg.job.jobsearch.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessagesService {
    private final MessageRepository messageRepository;

    @Override
    public List<MessagesDto> getAllMessage() throws MessageNotFoundException {
        List<Message> messages = messageRepository.findAll();
        if(messages.isEmpty()){
            throw new MessageNotFoundException();
        }

        return messages.stream()
                .map(this::mapToDo)
                .toList();
    }

    private MessagesDto mapToDo(Message message){
        return MessagesDto.builder()
                .id(message.getId())
                .respondedApplicants(message.getRespondedApplicant().getId())
                .content(message.getContent())
                .times(message.getTimes())
                .build();
    }
}