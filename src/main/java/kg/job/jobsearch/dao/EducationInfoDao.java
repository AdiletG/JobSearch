package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.EducationInfoMapper;
import kg.job.jobsearch.dto.create.EducationInfoCreateDto;
import kg.job.jobsearch.dto.update.EducationInfoUpdateDto;
import kg.job.jobsearch.model.EducationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EducationInfoDao {
    private final JdbcTemplate jdbcTemplate;

    public List<EducationInfoUpdateDto> getByResumeIdByUpdate(Long resumeId){
        String sql = """
                select * from education_info where resume_id = ?
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            EducationInfoUpdateDto educ = new EducationInfoUpdateDto();
            educ.setId(rs.getLong("id"));
            educ.setInstitution(rs.getString("institution"));
            educ.setProgram(rs.getString("program"));
            java.sql.Date startDate = rs.getDate("start_date");
            educ.setStartDate(startDate != null ? startDate.toLocalDate() : null);
            java.sql.Date endDate = rs.getDate("end_date");
            educ.setEndDate(endDate != null ? endDate.toLocalDate() : null);
            educ.setDegree(rs.getString("degree"));
            return educ;
        }, resumeId);
    }

    public List<EducationInfo> getAllEducationInfo(){
        String sql = "select * from education_info;";
        return jdbcTemplate.query(sql, new EducationInfoMapper());
    }

    public List<EducationInfo> getByResumeId(Long resumeId){
        String sql = """
                select * from education_info where resume_id = ?
                """;
        return jdbcTemplate.query(sql, new EducationInfoMapper(), resumeId);
    }

    public void save(Long resumeId, EducationInfoCreateDto dto){
        String sql = """
                insert into education_info(resume_id, institution, program, start_date, end_date, degree)
                values(?, ?, ?, ?, ?, ?)
                """;
        jdbcTemplate.update(sql, resumeId, dto.getInstitution(), dto.getProgram(), dto.getStartDate(),
                dto.getEndDate(), dto.getDegree());
    }

    public void update(Long id, EducationInfoUpdateDto dto){
        String sql = """
                update education_info
                set institution = ?, program = ?, start_date = ?, end_date = ?, degree = ?
                where id = ?
                """;
        jdbcTemplate.update(
                sql,
                dto.getInstitution(),
                dto.getProgram(),
                dto.getStartDate(),
                dto.getEndDate(),
                dto.getDegree(),
                id
        );
    };

    public void deleteById(Long id){
        String sql = "delete from education_info where id = ?";
        jdbcTemplate.update(sql, id);
    }
}