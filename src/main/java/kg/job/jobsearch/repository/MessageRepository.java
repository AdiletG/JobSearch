package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
