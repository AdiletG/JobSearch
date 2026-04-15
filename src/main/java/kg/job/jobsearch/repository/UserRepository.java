package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
