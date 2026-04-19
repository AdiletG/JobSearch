//package kg.job.jobsearch.dao;
//
//import kg.job.jobsearch.dao.mapper.ContactTypeMapper;
//import kg.job.jobsearch.model.ContactType;
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class ContactTypeDao {
//    private final JdbcTemplate jdbcTemplate;
//
//    public List<ContactType> getAllContactsType(){
//        String sql = "select * from contact_types;";
//        return jdbcTemplate.query(sql, new ContactTypeMapper());
//    }
//}