package com.itlabs.backend.web;

import com.itlabs.backend.models.User;
import com.itlabs.backend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLoginPage(Model model){
        model.addAttribute("bodyContent", "login");
        return "master-template";
    }

    /*@PostMapping
    public String login(@RequestParam String email, @RequestParam String password, Model model){
        User user = null;
        try {
            user = userService.login(email, password);
            request.getSession().setAttribute("user", user);
            return "redirect:/home";
        } catch (InvalidUserCredentialsException exception){
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }*/
}
