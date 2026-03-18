package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.ResumeMapper;
import kg.job.jobsearch.dao.mapper.UserMapper;
import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ResumeDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Resume> getAllResume(){
        String sql = "select * from resumes;";
        return jdbcTemplate.query(sql, new ResumeMapper());
    }

    public List<Resume> getResumeByCategory(int category){
        String sql = "select * from resumes where category_id = ?";
        return jdbcTemplate.query(sql, new ResumeMapper(), category);
    }

    public List<Resume> getResumeByApplicant(int applicantId){
        String sql = "select * from resumes where applicant_id = ?";
        return jdbcTemplate.query(sql, new ResumeMapper(), applicantId);
    }

    public List<Resume> getResumeByActive(boolean active){
        String sql = "select * from resumes where is_active = ?";
        return jdbcTemplate.query(sql, new ResumeMapper(), active);
    }
}