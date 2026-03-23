package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.ContactsInfoMapper;
import kg.job.jobsearch.dto.ContactsInfoCreateDto;
import kg.job.jobsearch.dto.ContactsInfoUpdateDto;
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

    public List<ContactsInfo> getByResumeId(Long resumeId){
        String sql = "select * from contacts_info where resume_id = ?";
        return jdbcTemplate.query(sql, new ContactsInfoMapper(), resumeId);
    }

    public void save(Long resumeId, ContactsInfoCreateDto dto){
        String sql = """
                insert into contacts_info(resume_id, type_id, contact_value)
                values(?, ?, ?)
                """;
        jdbcTemplate.update(sql, resumeId, dto.getType_id(), dto.getContactValue());
    }

    public void update(Long id, ContactsInfoUpdateDto dto){
        String sql = """
                update contacts_info 
                set type_id = ?, contact_value = ?
                where id = ?
                """;
        jdbcTemplate.update(
                sql,
                dto.getType_id(),
                dto.getContactValue(),
                id
        );
    }

    public void delete(Long id){
        String sql = "delete from contacts_info where id = ?";
        jdbcTemplate.update(sql, id);
    }
}