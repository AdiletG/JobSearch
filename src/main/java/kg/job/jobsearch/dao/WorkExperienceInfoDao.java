package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.WorkExperienceInfoMapper;
import kg.job.jobsearch.dto.EducationInfoCreateDto;
import kg.job.jobsearch.dto.WorkExperienceInfoCreateDto;
import kg.job.jobsearch.model.WorkExperienceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WorkExperienceInfoDao {
    private final JdbcTemplate jdbcTemplate;

    public List<WorkExperienceInfo> getAllWorkExperienceInfo(){
        String sql = "select * from work_experience_info;";
        return jdbcTemplate.query(sql, new WorkExperienceInfoMapper());
    }

    public void save(Long resumeId, WorkExperienceInfoCreateDto dto){
        String sql = """
                insert into work_experience_info(resume_id, years, company_name, position_in_company, responsibilities)
                values(?, ?, ?, ?, ?)
                """;
        jdbcTemplate.update(sql, resumeId, dto.getYears(), dto.getCompanyName(), dto.getPosition(),
                dto.getResponsibilities());
    }
}