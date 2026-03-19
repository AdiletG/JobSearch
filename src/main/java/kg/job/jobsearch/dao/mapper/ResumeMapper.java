package kg.job.jobsearch.dao.mapper;

import kg.job.jobsearch.model.Resume;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ResumeMapper implements RowMapper<Resume> {

    @Override
    public Resume mapRow(ResultSet rs, int rowNum) throws SQLException {
        Resume resume = new Resume();
        resume.setId(rs.getInt("id"));
        resume.setApplicantId(rs.getInt("applicant_id"));
        resume.setName(rs.getString("name"));
        resume.setCategoryId(rs.getInt("category_id"));
        resume.setSalary(rs.getBigDecimal("salary"));
        resume.setIsActive(rs.getBoolean("is_active"));
        Timestamp createdDate = rs.getTimestamp("created_date");
        Timestamp updateDate = rs.getTimestamp("update_date");

        resume.setCreatedDate(createdDate != null ? createdDate.toLocalDateTime() : null);
        resume.setUpdateDate(updateDate != null ? updateDate.toLocalDateTime() : null);

        return resume;
    }
}