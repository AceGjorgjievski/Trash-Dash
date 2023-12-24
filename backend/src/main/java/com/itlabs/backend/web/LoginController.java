package com.itlabs.backend.Web;

import com.itlabs.backend.models.User;
import com.itlabs.backend.models.exceptions.InvalidUserCredentialsException;
import com.itlabs.backend.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

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

//    @PostMapping
//    public String login(@RequestParam String email, @RequestParam String password, Model model,
//                        HttpServletRequest request){
//        User user = null;
//        try {
//            user = userService.login(email, password);
//            request.getSession().setAttribute("user", user);
//            return "redirect:/home";
//        } catch (InvalidUserCredentialsException exception){
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", exception.getMessage());
//            return "login";
//        }
//    }

    @PostMapping
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpServletRequest  request) {
        User user = null;

        try {
//            String email = request.getParameter("email");
//            String password = request.getParameter("password");

            user = this.userService.login(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
//            sessionEvent.getSession().getServletContext().setAttribute("user", username);
            return "redirect:/reports";
        } catch (Exception e) {
            System.out.println("Login - " + e.getMessage());
            return "redirect:/login?error="+e.getMessage();
        }
    }
}
