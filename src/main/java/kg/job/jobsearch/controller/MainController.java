package kg.job.jobsearch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("currentPage", "home");
        return "index";
    }
}