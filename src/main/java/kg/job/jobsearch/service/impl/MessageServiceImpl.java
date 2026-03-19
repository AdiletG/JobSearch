package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.MessageDao;
import kg.job.jobsearch.dto.MessagesDto;
import kg.job.jobsearch.exception.MessageNotFoundException;
import kg.job.jobsearch.model.Message;
import kg.job.jobsearch.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessagesService {
    private final MessageDao messageDao;

    @Override
    public List<MessagesDto> getAllMessage() throws MessageNotFoundException {
        List<Message> messages = messageDao.getAllMessage();
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
                .respondedApplicants(message.getRespondedApplicants())
                .content(message.getContent())
                .times(message.getTimes())
                .build();
    }
}