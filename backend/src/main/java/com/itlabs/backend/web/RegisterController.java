package com.itlabs.backend.web;

import com.itlabs.backend.models.enums.RoleType;
import com.itlabs.backend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent", "register");
        return "master-template";
    }

    /*@PostMapping
    public String register(@RequestParam String email,@RequestParam String password,@RequestParam String repeatedPassword,
                           @RequestParam String name,@RequestParam String surname, @RequestParam String phoneNumber){
        try {
            userService.register(email, password, repeatedPassword, name, surname, RoleType.USER, phoneNumber);
            return "redirect:/login";
        }catch (PasswordDoNotMatchException | InvalidArgumentsException exception){
            return "redirect:/register?error=" + exception.getMessage();
        }
    }*/
}
