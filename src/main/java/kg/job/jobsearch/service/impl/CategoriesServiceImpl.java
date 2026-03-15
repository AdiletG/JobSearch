package kg.job.jobsearch.service.impl;

import kg.job.jobsearch.dto.CategoriesDto;
import kg.job.jobsearch.service.CategoriesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    private List<CategoriesDto> categories = new ArrayList<>(
            List.of(
                    CategoriesDto.builder()
                            .id(1)
                            .name("Driver")
                            .parent_id(0)
                            .build()
            )
    );

    @Override
    public List<CategoriesDto> getAllCategories(){
        return new ArrayList<>(categories);
    }

}