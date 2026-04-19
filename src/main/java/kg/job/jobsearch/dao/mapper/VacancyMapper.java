//package kg.job.jobsearch.dao.mapper;
//
//import kg.job.jobsearch.model.Vacancy;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.Date;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class VacancyMapper implements RowMapper<Vacancy> {
//
//    @Override
//    public Vacancy mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Vacancy vacancy = new Vacancy();
//        vacancy.setId(rs.getLong("id"));
//        vacancy.setName(rs.getString("name"));
//        vacancy.setDescription(rs.getString("description"));
//        vacancy.setCategoryId(rs.getLong("category_id"));
//        vacancy.setSalary(rs.getBigDecimal("salary"));
//        vacancy.setExpFrom(rs.getInt("exp_from"));
//        vacancy.setExpTo(rs.getInt("exp_to"));
//        vacancy.setIsActive(rs.getObject("is_active", Boolean.class));
//        vacancy.setAuthorId(rs.getLong("author_id"));
//
//        Date createdDate = rs.getDate("created_date");
//        Date updateDate = rs.getDate("update_date");
//
//        vacancy.setCreatedDate(createdDate != null ? createdDate.toLocalDate() : null);
//        vacancy.setUpdateDate(updateDate != null ? updateDate.toLocalDate() : null);
//        return vacancy;
//    }
//}