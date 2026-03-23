package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.RespondedApplicantMapper;
import kg.job.jobsearch.model.RespondedApplicant;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RespondedApplicantDao {

    private final JdbcTemplate jdbcTemplate;

    public List<RespondedApplicant> getAllResponds(){
        String sql = "select * from responded_applicants;";
        return jdbcTemplate.query(sql, new RespondedApplicantMapper());
    }

    public void delete(Long resume_id){
        String sql = "delete from responded_applicants where resume_id = ?";
        jdbcTemplate.update(sql, resume_id);
    }
}