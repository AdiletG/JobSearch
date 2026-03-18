package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.VacancyMapper;
import kg.job.jobsearch.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VacancyDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Vacancy> getALlVacancy(){
        String sql = "select * from vacancies;";
        return jdbcTemplate.query(sql, new VacancyMapper());
    }
}