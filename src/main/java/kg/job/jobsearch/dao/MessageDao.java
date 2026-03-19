package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.EducationInfoMapper;
import kg.job.jobsearch.dao.mapper.MessageMapper;
import kg.job.jobsearch.model.EducationInfo;
import kg.job.jobsearch.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class MessageDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Message> getAllMessage(){
        String sql = "select * from messages;";
        return jdbcTemplate.query(sql, new MessageMapper());
    }
}