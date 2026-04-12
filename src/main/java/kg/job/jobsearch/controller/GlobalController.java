package kg.job.jobsearch.controller;

import kg.job.jobsearch.exception.notFoundException.CategoryNotFoundException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.service.CategoriesService;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalController {
    private final UserService userService;
    private final CategoriesService categoriesService;

    @ModelAttribute
    public void addUser(Model model, Principal principal) throws UserNotFoundException {
        if (principal != null) {
            model.addAttribute("user",
                    userService.findByEmail(principal.getName()));
        }
    }

    @ModelAttribute("accountTypes")
    public Map<String, String> accountTypes() {
        Map<String, String> types = new LinkedHashMap<>();
        types.put("", "Выберите тип аккаунта");
        types.put("APPLICANT", "Соискатель");
        types.put("EMPLOYER", "Работодатель");
        return types;
    }

    @ModelAttribute("categories")
    public Map<String, String> categories() throws CategoryNotFoundException {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("", "Выберите категорию");
        categoriesService.getAllCategories().forEach(c -> map.put(
                String.valueOf(c.getId()), c.getName()
        ));
        return map;
    }
}