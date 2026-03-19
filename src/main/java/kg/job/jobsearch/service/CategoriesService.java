package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.CategoriesDto;
import kg.job.jobsearch.exception.CategoryNotFoundException;

import java.util.List;

public interface CategoriesService {
    List<CategoriesDto> getAllCategories() throws CategoryNotFoundException;
}
