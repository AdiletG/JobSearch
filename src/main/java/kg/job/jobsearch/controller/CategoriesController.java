package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.CategoriesDto;
import kg.job.jobsearch.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoriesController {

    private CategoriesService categoriesService;

    @GetMapping
    public ResponseEntity<List<CategoriesDto>> getAllCategories(){
        return ResponseEntity.ok(categoriesService.getAllCategories());
    }

}