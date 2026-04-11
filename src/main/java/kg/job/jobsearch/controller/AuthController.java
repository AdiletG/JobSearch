package kg.job.jobsearch.controller;

import jakarta.validation.Valid;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.enums.AccountTypeEnums;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("login")
    public String login(Model model) {
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("userDto", new UsersCreateDto());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerPost(
            @Valid @ModelAttribute("userDto") UsersCreateDto dto,
            BindingResult bindingResult,
            Model model) throws UserDataCreateException {
        if (!bindingResult.hasErrors()) {
            userService.createUser(dto);
            return "redirect:/";
        }
        model.addAttribute("userDto", dto);
        return "auth/register";
    }

}