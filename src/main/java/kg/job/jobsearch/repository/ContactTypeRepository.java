package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactTypeRepository extends JpaRepository<ContactType, Long> {
}
