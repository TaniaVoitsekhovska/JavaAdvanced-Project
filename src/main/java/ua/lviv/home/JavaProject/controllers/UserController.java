package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.home.JavaProject.domain.User;
import ua.lviv.home.JavaProject.services.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/cabinet")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "cabinet";
    }

    @GetMapping("/allUsers")
    public String allUsers(Model model){
        List<User> usersList= userService.findAll();
        model.addAttribute("users",usersList);
        return "usersList";
    }
}
