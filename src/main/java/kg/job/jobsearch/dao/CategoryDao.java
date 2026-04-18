//package kg.job.jobsearch.dao;
//
//import kg.job.jobsearch.dao.mapper.CategoryMapper;
//import kg.job.jobsearch.model.Category;
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class CategoryDao {
//    private final JdbcTemplate jdbcTemplate;
//
//    public List<Category> getAllCategory(){
//        String sql = "select * from categories;";
//        return jdbcTemplate.query(sql, new CategoryMapper());
//    }
//
//    public String getCategoryName(Long id){
//        String sql = """
//                select * from categories where id = ?
//                """;
//        return jdbcTemplate.queryForObject(sql, String.class, id);
//    }
//
//}