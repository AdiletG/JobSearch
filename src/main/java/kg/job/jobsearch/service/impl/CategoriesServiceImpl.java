package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dao.CategoryDao;
import kg.job.jobsearch.dto.CategoriesDto;
import kg.job.jobsearch.exception.notFoundException.CategoryNotFoundException;
import kg.job.jobsearch.model.Category;
import kg.job.jobsearch.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {
   private final CategoryDao categoryDao;

    @Override
    public List<CategoriesDto> getAllCategories() throws CategoryNotFoundException {
       List<Category> categories = categoryDao.getAllCategory();
       if (categories.isEmpty()){
           throw new CategoryNotFoundException();
       }
        return categories.stream()
                .map(this::mapToDo)
                .toList();
    }

    private CategoriesDto mapToDo(Category category){
       return CategoriesDto.builder()
               .id(category.getId())
               .name(category.getName())
               .parentId(category.getParentId())
               .build();
    }
}