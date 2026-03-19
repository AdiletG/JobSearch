package kg.job.jobsearch.dao.mapper;

import kg.job.jobsearch.model.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MessageMapper implements RowMapper<Message> {

    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message message = new Message();
        message.setId(rs.getInt("id"));
        message.setRespondedApplicants(rs.getInt("responded_applicant_id"));
        message.setContent(rs.getString("content"));
        Timestamp times = rs.getTimestamp("times");

        message.setTimes(times != null ? times.toLocalDateTime() : null);
        return message;
    }
}