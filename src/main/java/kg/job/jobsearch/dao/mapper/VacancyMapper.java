package kg.job.jobsearch.dao.mapper;

import kg.job.jobsearch.model.Vacancy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class VacancyMapper implements RowMapper<Vacancy> {

    @Override
    public Vacancy mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(rs.getInt("id"));
        vacancy.setName(rs.getString("name"));
        vacancy.setDescription(rs.getString("description"));
        vacancy.setCategory_id(rs.getInt("category_id"));
        vacancy.setSalary(rs.getBigDecimal("salary"));
        vacancy.setExp_from(rs.getInt("exp_from"));
        vacancy.setExp_to(rs.getInt("exp_to"));
        vacancy.setIs_active(rs.getBoolean("is_active"));
        vacancy.setAuthor_id(rs.getInt("author_id"));

        Timestamp createdDate = rs.getTimestamp("created_date");
        Timestamp updateDate = rs.getTimestamp("update_date");

        vacancy.setCreated_date(createdDate != null ? createdDate.toLocalDateTime() : null);
        vacancy.setUpdate_time(updateDate != null ? updateDate.toLocalDateTime() : null);
        return vacancy;
    }
}