package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.VacancyMapper;
import kg.job.jobsearch.dto.create.VacanciesCreateDto;
import kg.job.jobsearch.dto.update.VacanciesUpdateDto;
import kg.job.jobsearch.exception.notFoundException.VacancyNotFoundException;
import kg.job.jobsearch.exception.updateException.VacancyDataUpdateException;
import kg.job.jobsearch.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VacancyDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public VacanciesUpdateDto getByIdForUpdate(Long id) throws VacancyNotFoundException {
        String sql = "SELECT * FROM vacancies WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            VacanciesUpdateDto dto = new VacanciesUpdateDto();
            dto.setId(rs.getLong("id"));
            dto.setName(rs.getString("name"));
            dto.setDescription(rs.getString("description"));
            dto.setCategoryId(rs.getLong("category_id"));
            dto.setSalary(rs.getBigDecimal("salary"));
            dto.setExpFrom(rs.getInt("exp_from"));
            dto.setExpTo(rs.getInt("exp_to"));
            dto.setIsActive(rs.getBoolean("is_active"));
            return dto;
        }, id);
    }

    public List<Vacancy> getALlVacancy(){
        String sql = "select * from vacancies;";
        return jdbcTemplate.query(sql, new VacancyMapper());
    }

    public List<Vacancy> getALlVacancyByAuthor(Long id){
        String sql = "select * from vacancies where author_id = ?";
        return jdbcTemplate.query(sql, new VacancyMapper(), id);
    }

    public List<Vacancy> getVacancyByCategory(Long category){
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

    public List<Vacancy> getVacanciesByApplicant(Long id){

        String sql = """
        SELECT v.*
        FROM vacancies v
        JOIN responded_applicants r ON v.id = r.vacancy_id
        JOIN resumes res ON r.resume_id = res.id
        WHERE res.applicant_id = ?
        """;

        return jdbcTemplate.query(sql, new VacancyMapper(), id);
    }

    public void createVacancy(Long authorId, VacanciesCreateDto dto) throws SQLException {
        String sql = """
        INSERT INTO vacancies (
            name, description, category_id, salary,
            exp_from, exp_to, is_active, author_id,
            created_date
        )
        VALUES (?, ?, ?, ?, ?, ?, true, ?, now())
        """;

        jdbcTemplate.update(
                sql,
                dto.getName(),
                dto.getDescription(),
                dto.getCategoryId(),
                dto.getSalary(),
                dto.getExpFrom(),
                dto.getExpTo(),
                authorId
                );
    }

    public void update(Long vacancyId, Vacancy dto) throws VacancyDataUpdateException {
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

    public void delete(Long id) throws VacancyNotFoundException {
        String sql = "delete from vacancies where id = ?";
        jdbcTemplate.update(sql, id);
    }
}