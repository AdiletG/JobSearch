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
        vacancy.setCategoryId(rs.getInt("category_id"));
        vacancy.setSalary(rs.getBigDecimal("salary"));
        vacancy.setExpFrom(rs.getInt("exp_from"));
        vacancy.setExpTo(rs.getInt("exp_to"));
        vacancy.setIsActive(rs.getObject("is_active", Boolean.class));
        vacancy.setAuthorId(rs.getInt("author_id"));

        Timestamp createdDate = rs.getTimestamp("created_date");
        Timestamp updateDate = rs.getTimestamp("update_date");

        vacancy.setCreatedDate(createdDate != null ? createdDate.toLocalDateTime() : null);
        vacancy.setUpdateDate(updateDate != null ? updateDate.toLocalDateTime() : null);
        return vacancy;
    }
}