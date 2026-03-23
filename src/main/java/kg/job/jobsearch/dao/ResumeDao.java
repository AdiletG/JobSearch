package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.ResumeMapper;
import kg.job.jobsearch.dao.mapper.UserMapper;
import kg.job.jobsearch.dto.ResumeCreateDto;
import kg.job.jobsearch.dto.ResumeUpdateDto;
import kg.job.jobsearch.dto.ResumesDto;
import kg.job.jobsearch.exception.ResumeNotFoundException;
import kg.job.jobsearch.model.Resume;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ResumeDao {
    private final JdbcTemplate jdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();

    public List<Resume> getAllResume(){
        String sql = "select * from resumes;";
        return jdbcTemplate.query(sql, new ResumeMapper());
    }

    public List<Resume> getResumeByCategory(int category){
        String sql = "select * from resumes where category_id = ?";
        return jdbcTemplate.query(sql, new ResumeMapper(), category);
    }

    public List<Resume> getResumeByActive(boolean active){
        String sql = "select * from resumes where is_active = ?";
        return jdbcTemplate.query(sql, new ResumeMapper(), active);
    }

    public Optional<Resume> getResumeById(Long resumeId){
        String sql = """
                select * from resumes where id = ?
                """;
        return Optional.ofNullable(
                DataAccessUtils.singleResult(jdbcTemplate.query(sql, new ResumeMapper(), resumeId)
                )
        );
    }

    public List<Resume> getResumeByApplicant(Long applicantId){
        String sql = "select * from resumes where applicant_id = ?";
        return jdbcTemplate.query(sql, new ResumeMapper(), applicantId);
    }

    public Long createResume(Long applicantId, ResumeCreateDto dto) throws ResumeNotFoundException {
        String sql = """
                insert into resumes (applicant_id, name, category_id, salary, is_active, created_date)
                values(?, ?, ?, ?, ?, now())
                """;

        jdbcTemplate.update(resume -> {
            PreparedStatement ps = resume.prepareStatement(sql, new String[]{"id"});
            ps.setLong(1, applicantId);
            ps.setString(2, dto.getName());
            ps.setLong(3, dto.getCategoryId());
            ps.setBigDecimal(4, dto.getSalary());
            ps.setBoolean(5,true);
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() == null) throw new ResumeNotFoundException("Resume id was not generated");

        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public void updateResume(Long resumeId, Resume resume){
        String sql = """
            update resumes
            set name = ?, category_id = ?, salary = ?, update_date = now()
            where id = ?
            """;

        jdbcTemplate.update(
                sql,
                resume.getName(),
                resume.getCategoryId(),
                resume.getSalary(),
                resumeId
        );
    }

    public void deleteResume(Long resumeId){
        String sql = "delete from resumes where id = ?";
        jdbcTemplate.update(sql, resumeId);
    }
}