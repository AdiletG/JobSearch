package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.UserMapper;
import kg.job.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public List<User> getAllUser(){
        String sql = "select * from usr;";

        return jdbcTemplate.query(sql, new UserMapper());
    }

    public Optional<User> findById(int id){
        String sql = "select * from usr where id = ?";

        return Optional.ofNullable(
                DataAccessUtils.singleResult(jdbcTemplate.query(sql, new UserMapper(), id)
                )
        );
    }
}