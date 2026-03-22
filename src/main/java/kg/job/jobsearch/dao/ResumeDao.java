package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.ResumeMapper;
import kg.job.jobsearch.dao.mapper.UserMapper;
import kg.job.jobsearch.dto.ResumeCreateDto;
import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.exception.ResumeNotFoundException;
import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
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

    public Long createResume(Long applicantId, ResumeCreateDto dto) throws ResumeNotFoundException {
        String sql = """
                insert into resumes (applicant_id, name, salary, is_active, create_date)
                values(?, ?, ?, ?, ?, now())
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(resume -> {
            PreparedStatement ps = resume.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, applicantId);
            ps.setString(2, dto.getName());
            ps.setLong(3, dto.getCategoryId());
            ps.setBigDecimal(4, dto.getSalary());
            ps.setBoolean(5,true);
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() == null) throw new ResumeNotFoundException("Resume id was not generated");

        return (long) keyHolder.getKey().intValue();
    }
}