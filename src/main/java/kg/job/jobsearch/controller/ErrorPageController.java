package kg.job.jobsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController {
    @GetMapping("/errors/error")
    public String errorPage() {
        return "errors/error";
    }
}