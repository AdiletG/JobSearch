package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.User;
import kg.job.jobsearch.model.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByName(String name);
    List<User> findByPhoneNumber(String phoneNumber);
    boolean existsByEmail(String email);
    @Query("SELECT u FROM User u JOIN u.resumes r JOIN r.respondedApplicants ra WHERE ra.vacancy.id = :vacancyId")
    List<User> findApplicantsByVacancyId(@Param("vacancyId") Long vacancyId);
}
