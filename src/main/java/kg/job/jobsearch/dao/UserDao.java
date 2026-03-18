package kg.job.jobsearch.dao;

import kg.job.jobsearch.dao.mapper.UserMapper;
import kg.job.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public List<User> getAllUser(){
        String sql = "select * from users;";

        return jdbcTemplate.query(sql, new UserMapper());
    }

    public Optional<User> findById(int id){
        String sql = "select * from users where id = ?";

        return Optional.ofNullable(
                DataAccessUtils.singleResult(jdbcTemplate.query(sql, new UserMapper(), id)
                )
        );
    }

    public Optional<User> findByEmail(String email){
        String sql = "select * from users where email = ?";

        return Optional.ofNullable(
                DataAccessUtils.singleResult(jdbcTemplate.query(sql, new UserMapper(), email)
                )
        );
    }

    public List<User> findByName(String name){
        String sql = "select * from users where name = ?";
        return jdbcTemplate.query(sql, new UserMapper(), name);
    }

    public List<User> findByPhoneNumber(String number){
        String sql = "select * from users where phone_number = ?";
        return jdbcTemplate.query(sql, new UserMapper(), number);
    }

    public Boolean existsUserByEmail(String email){
        String sql = "select exists (select 1 from users where email = ?)";
        return jdbcTemplate.queryForObject(sql, Boolean.class, email);
    }
}