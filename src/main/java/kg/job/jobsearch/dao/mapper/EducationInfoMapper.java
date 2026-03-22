package kg.job.jobsearch.dao.mapper;

import kg.job.jobsearch.model.EducationInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationInfoMapper implements RowMapper<EducationInfo> {

    @Override
    public EducationInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        EducationInfo educationInfo = new EducationInfo();
        educationInfo.setId(rs.getInt("id"));
        educationInfo.setResumeId(rs.getInt("resume_id"));
        educationInfo.setInstitution(rs.getString("institution"));
        educationInfo.setProgram(rs.getString("program"));
        educationInfo.setStartDate(rs.getDate("start_date").toLocalDate());
        educationInfo.setEndDate(rs.getDate("end_date").toLocalDate());
        educationInfo.setDegree(rs.getString("degree"));
        return educationInfo;
    }
}