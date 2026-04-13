package kg.job.jobsearch.dao;

import io.jsonwebtoken.security.PublicJwkBuilder;
import kg.job.jobsearch.dao.mapper.UserMapper;
import kg.job.jobsearch.dto.update.UsersUpdateDto;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();

    public UsersUpdateDto getByEmailForUpdate(String email){
        String sql = "select * from users where email = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                        UsersUpdateDto.builder()
                                .id(rs.getLong("id"))
                                .name(rs.getString("name"))
                                .surname(rs.getString("surname"))
                                .age(rs.getInt("age"))
                                .email(rs.getString("email"))
                                .phoneNumber(rs.getString("phone_number"))
                                .avatarPath(rs.getString("avatar"))
                                .build()
                , email);
    }

    public List<User> getAllUser(){
        String sql = "select * from users;";

        return jdbcTemplate.query(sql, new UserMapper());
    }

    public Optional<User> findById(Long id){
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

    public List<User> getApplicantByVacancies(Long id){
        String sql = """
        SELECT u.*
        FROM users u
        JOIN resumes res ON u.id = res.applicant_id
        JOIN responded_applicants r ON res.id = r.resume_id
        WHERE r.vacancy_id = ?
        """;

        return jdbcTemplate.query(sql, new UserMapper(), id);
    }

    public Long createUser(User dto) throws SQLException {
        String sql = """
                insert into users(name, surname, age, email, password, phone_number, avatar, account_type)
                values(?, ?, ?, ?, ?, ?, ?, ?)
                """;
        jdbcTemplate.update(user -> {
            PreparedStatement ps = user.prepareStatement(sql, new String[]{"id"});
           ps.setString(1, dto.getName());
           ps.setString(2, dto.getSurname());
           ps.setInt(3, dto.getAge());
           ps.setString(4, dto.getEmail());
           ps.setString(5, dto.getPassword());
           ps.setString(6, dto.getPhoneNumber());
           ps.setString(7, dto.getAvatar());
           ps.setString(8, dto.getAccountType().name());
            return ps;
        }, keyHolder);


        if (keyHolder.getKey() == null) throw new UserDataCreateException();

        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }



    public void updateUser(Long userId, User dto) throws SQLException{
        String sql = """
                update users 
                set name = ?, surname = ?, age = ?, email = ?, password = ?, phone_number = ?, avatar = ?
                where id = ?
                """;

        jdbcTemplate.update(
                sql,
                dto.getName(),
                dto.getSurname(),
                dto.getAge(),
                dto.getEmail(),
                dto.getPassword(),
                dto.getPhoneNumber(),
                dto.getAvatar(),
                userId
        );
    }

    public void deleteUser(Long userId){
        String sql = "delete from users where id = ?";
        jdbcTemplate.update(sql, userId);
    }
}