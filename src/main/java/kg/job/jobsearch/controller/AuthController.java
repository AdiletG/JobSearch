package kg.job.jobsearch.controller;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import kg.job.jobsearch.dto.create.UsersCreateDto;
import kg.job.jobsearch.exception.createException.UserDataCreateException;
import kg.job.jobsearch.exception.notFoundException.UserNotFoundException;
import kg.job.jobsearch.model.User;
import kg.job.jobsearch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;


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

    @GetMapping("forgot-password")
    public String getForgotPassword(){
        return "auth/forgot-password-form";
    }

    @GetMapping("reset-password")
    public String showResetPasswordForm(@RequestParam String token, Model model) {
        try {
            userService.findByToken(token);
            model.addAttribute("token", token);
        } catch (UserNotFoundException e) {
            model.addAttribute("error", "Invalid token!");
        }
        return "auth/reset-password-form";
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

    @PostMapping("forgot-password")
    public String postForgotPassword(HttpServletRequest request, Model model){
        try{
            userService.makeResetPasswordLink(request);
            model.addAttribute("message", "Мы отравили ссылку на сброс пароля вам на почту");
        }catch (UserNotFoundException | UnsupportedEncodingException e){
            model.addAttribute("error", e.getMessage());

        }catch (MessagingException e){
            model.addAttribute("error", "Ошибка при отправки ссылки на вашу почту");
        }
        return "auth/forgot-password-form";
    }

    @PostMapping("reset-password")
    public String processResetPassword(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String pwd = request.getParameter("password");
        try {
            User user = userService.findByToken(token);
            userService.updatePassword(user, pwd);
            model.addAttribute("message", "You have successfully changed your password");
        } catch (UserNotFoundException e) {
            model.addAttribute("message", "Invalid token");
        }
        return "partial/message";
    }

}