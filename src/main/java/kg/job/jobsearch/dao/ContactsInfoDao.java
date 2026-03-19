package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.ContactsInfoMapper;
import kg.job.jobsearch.model.ContactsInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactsInfoDao {
    private final JdbcTemplate jdbcTemplate;

    public List<ContactsInfo> getAllContactsInfo(){
        String sql = "select * from contacts_info;";
        return jdbcTemplate.query(sql, new ContactsInfoMapper());
    }
}