package kg.job.jobsearch.repository;

import kg.job.jobsearch.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
