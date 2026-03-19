package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.EducationInfoMapper;
import kg.job.jobsearch.model.EducationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EducationInfoDao {
    private final JdbcTemplate jdbcTemplate;

    public List<EducationInfo> getAllEducationInfo(){
        String sql = "select * from education_info;";
        return jdbcTemplate.query(sql, new EducationInfoMapper());
    }
}