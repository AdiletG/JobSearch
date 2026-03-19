package kg.job.jobsearch.dao.mapper;

import kg.job.jobsearch.model.ContactType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactTypeMapper implements RowMapper<ContactType> {

    @Override
    public ContactType mapRow(ResultSet rs, int rowNum) throws SQLException {
        ContactType contactType = new ContactType();
        contactType.setId(rs.getInt("id"));
        contactType.setType(rs.getString("type"));
        return contactType;
    }
}