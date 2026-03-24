package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.VacancyMapper;
import kg.job.jobsearch.dto.create.VacanciesCreateDto;
import kg.job.jobsearch.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VacancyDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Vacancy> getALlVacancy(){
        String sql = "select * from vacancies;";
        return jdbcTemplate.query(sql, new VacancyMapper());
    }

    public List<Vacancy> getVacancyByCategory(int category){
        String sql = "select * from vacancies where category_id = ?";
        return jdbcTemplate.query(sql, new VacancyMapper(), category);
    }

    public List<Vacancy> getVacancyByActive(boolean active){
        String sql = "select * from vacancies where is_active = ?";
        return jdbcTemplate.query(sql, new VacancyMapper(), active);
    }

    public Optional<Vacancy> getVacancyById(Long vacancyId){
        String sql = """
                select * from vacancies where id = ?
                """;
        return Optional.ofNullable(
                DataAccessUtils.singleResult(jdbcTemplate.query(sql, new VacancyMapper(), vacancyId)
                )
        );
    }

    public List<Vacancy> getVacanciesByApplicant(int id){

        String sql = """
        SELECT v.*
        FROM vacancies v
        JOIN responded_applicants r ON v.id = r.vacancy_id
        JOIN resumes res ON r.resume_id = res.id
        WHERE res.applicant_id = ?
        """;

        return jdbcTemplate.query(sql, new VacancyMapper(), id);
    }

    public void createVacancy(Long authorId, VacanciesCreateDto dto) {
        String sql = """
        INSERT INTO vacancies (
            name, description, category_id, salary,
            exp_from, exp_to, is_active, author_id,
            created_date
        )
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, now())
        """;

        jdbcTemplate.update(
                sql,
                dto.getName(),
                dto.getDescription(),
                dto.getCategoryId(),
                dto.getSalary(),
                dto.getExpFrom(),
                dto.getExpTo(),
                dto.getIsActive(),
                authorId
                );
    }

    public void update(Long vacancyId, Vacancy dto){
        String sql = """
                update vacancies
                set name = ?, description = ?, category_id = ?, salary = ?, exp_from = ?, exp_to = ?,
                is_active = ?, update_date = now()
                where id = ?
                """;

        jdbcTemplate.update(
                sql,
                dto.getName(),
                dto.getDescription(),
                dto.getCategoryId(),
                dto.getSalary(),
                dto.getExpFrom(),
                dto.getExpTo(),
                dto.getIsActive(),
                vacancyId
        );
    }

    public void delete(Long id){
        String sql = "delete from vacancies where id = ?";
        jdbcTemplate.update(sql, id);
    }
}