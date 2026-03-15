package kg.job.jobsearch.service;

import kg.job.jobsearch.dto.CategoriesDto;

import java.util.List;

public interface CategoriesService {
    List<CategoriesDto> getAllCategories();
}
