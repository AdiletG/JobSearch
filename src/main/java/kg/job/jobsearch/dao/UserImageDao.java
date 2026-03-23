package kg.job.jobsearch.dao;

import kg.job.jobsearch.model.UserImage;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserImageDao {
    private final JdbcTemplate jdbcTemplate;

    public void save(Long userId, String filename) {
        String sql = "insert into movie_images (movie_id, filename) " +
                "values((select id from movie where id = ?), ?)";
        jdbcTemplate.update(sql, userId, filename);
    }

    public Optional<UserImage> findByUserId(Long userId) {
        String sql = "select * from movie_images where movie_id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserImage.class), userId)
                )
        );
    }
}