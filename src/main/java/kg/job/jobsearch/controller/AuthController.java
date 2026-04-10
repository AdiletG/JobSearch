package kg.job.jobsearch.controller;

import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(Model model){
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerPost(UsersCreateDto dto) throws UserDataCreateException {
        userService.createUser(dto);
        return "redirect:/";
    }

}