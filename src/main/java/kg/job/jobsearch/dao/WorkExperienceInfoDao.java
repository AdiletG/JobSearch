package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.WorkExperienceInfoMapper;
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
}