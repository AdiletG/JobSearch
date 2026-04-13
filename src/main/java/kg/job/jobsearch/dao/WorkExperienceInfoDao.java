package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.WorkExperienceInfoMapper;
import kg.job.jobsearch.dto.create.WorkExperienceInfoCreateDto;
import kg.job.jobsearch.dto.update.WorkExperienceInfoUpdateDto;
import kg.job.jobsearch.model.WorkExperienceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkExperienceInfoDao {
    private final JdbcTemplate jdbcTemplate;

    public List<WorkExperienceInfoUpdateDto> getUpdateList(Long resumeId){
        String sql = """
                select * from work_experience_info where id = ?
                """;
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            WorkExperienceInfoUpdateDto work = new WorkExperienceInfoUpdateDto();
            work.setId(rs.getLong("id"));
            work.setCompanyName(rs.getString("company_name"));
            work.setPosition(rs.getString("position_in_company"));
            work.setYears(rs.getInt("years"));
            work.setResponsibilities(rs.getString("responsibilities"));
            return work;
        }, resumeId);
    }

    public List<WorkExperienceInfo> getAllWorkExperienceInfo(){
        String sql = "select * from work_experience_info;";
        return jdbcTemplate.query(sql, new WorkExperienceInfoMapper());
    }

    public List<WorkExperienceInfo> getByResumeId(Long resumeId){
        String sql = """
                select * from work_experience_info where id = ?
                """;
       return jdbcTemplate.query(sql, new WorkExperienceInfoMapper(), resumeId);
    }

    public void save(Long resumeId, WorkExperienceInfoCreateDto dto){
        String sql = """
                insert into work_experience_info(resume_id, years, company_name, position_in_company, responsibilities)
                values(?, ?, ?, ?, ?)
                """;
        jdbcTemplate.update(sql, resumeId, dto.getYears(), dto.getCompanyName(), dto.getPosition(),
                dto.getResponsibilities());
    }

    public void update(Long id, WorkExperienceInfoUpdateDto dto){
        String sql = """
                update work_experience_info
                set year = ?, company_name = ?, position_in_company = ?, responsibilities = ?
                where id = ?
                """;

        jdbcTemplate.update(
                sql,
                dto.getYears(),
                dto.getCompanyName(),
                dto.getPosition(),
                dto.getResponsibilities(),
                id
        );
    }

    public void deleteById(Long id){
        String sql = "delete from work_experience_info where resume_id = ?";
        jdbcTemplate.update(sql, id);
    }
}