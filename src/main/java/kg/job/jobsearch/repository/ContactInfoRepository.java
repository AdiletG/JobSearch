package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.ContactsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactInfoRepository extends JpaRepository<ContactsInfo, Long> {
}
