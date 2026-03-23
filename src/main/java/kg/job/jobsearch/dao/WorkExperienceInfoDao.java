package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.WorkExperienceInfoMapper;
import kg.job.jobsearch.dto.WorkExperienceInfoCreateDto;
import kg.job.jobsearch.dto.WorkExperienceInfoUpdateDto;
import kg.job.jobsearch.model.WorkExperienceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WorkExperienceInfoDao {
    private final JdbcTemplate jdbcTemplate;

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
        String sql = "delete from work_experience_info where id = ?";
        jdbcTemplate.update(sql, id);
    }
}