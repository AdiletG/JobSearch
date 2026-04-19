//package kg.job.jobsearch.dao.mapper;
//
//import kg.job.jobsearch.model.ContactsInfo;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ContactsInfoMapper implements RowMapper<ContactsInfo> {
//
//    @Override
//    public ContactsInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
//        ContactsInfo contactsInfo = new ContactsInfo();
//        contactsInfo.setId(rs.getLong("id"));
//        contactsInfo.setType_id(rs.getLong("type_id"));
//        contactsInfo.setResume_id(rs.getLong("resume_id"));
//        contactsInfo.setContactValue(rs.getString("contact_value"));
//        return contactsInfo;
//    }
//}