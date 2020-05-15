package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.home.JavaProject.dtos.UserRegisterRequest;
import ua.lviv.home.JavaProject.services.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@ModelAttribute UserRegisterRequest userDto){
        userService.save(userDto);
        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String getRegisterPage(Model model){
        model.addAttribute("userDto", new UserRegisterRequest());
        return "registration";
    }
}
