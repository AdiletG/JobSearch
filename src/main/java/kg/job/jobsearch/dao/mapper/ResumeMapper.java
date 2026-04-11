package kg.job.jobsearch.dao.mapper;

import kg.job.jobsearch.model.Resume;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResumeMapper implements RowMapper<Resume> {

    @Override
    public Resume mapRow(ResultSet rs, int rowNum) throws SQLException {
        Resume resume = new Resume();
        resume.setId(rs.getLong("id"));
        resume.setApplicantId(rs.getLong("applicant_id"));
        resume.setName(rs.getString("name"));
        resume.setCategoryId(rs.getLong("category_id"));
        resume.setSalary(rs.getBigDecimal("salary"));
        resume.setIsActive(rs.getBoolean("is_active"));
        Date createdDate = rs.getDate("created_date");
        Date updateDate = rs.getDate("update_date");

        resume.setCreatedDate(createdDate != null ? createdDate.toLocalDate() : null);
        resume.setUpdateDate(updateDate != null ? updateDate.toLocalDate() : null);

        return resume;
    }
}