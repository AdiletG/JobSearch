package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.MessagesDto;
import kg.job.jobsearch.exception.MessageNotFoundException;

import java.util.List;

public interface MessagesService {
    List<MessagesDto> getAllMessage() throws MessageNotFoundException;
}
