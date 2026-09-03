package com.quiz.QuizApplication.Controller;

import com.quiz.QuizApplication.Entity.User;
import com.quiz.QuizApplication.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/doRegister")
    public String doRegister(User user) {
        userService.doRegister(user);
        return "redirect:/login";
    }

    @PostMapping("/login_home")
    public String loginHome(User user) {
        User userFromDb = userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (userFromDb.getRole().equals("Admin")) {
            return "redirect:/admin_home";
        } else {
            return "redirect:/user_home";
        }
    }


    @GetMapping("/user_home")
    public String userHome(User user) {
        return "user_home_page";
    }

}
