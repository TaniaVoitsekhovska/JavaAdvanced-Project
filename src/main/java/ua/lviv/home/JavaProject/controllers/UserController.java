package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.home.JavaProject.domain.User;
import ua.lviv.home.JavaProject.services.CustomUserDetails;
import ua.lviv.home.JavaProject.services.UserService;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;


@Controller
public class UserController {

    private final UserService userService;
    private final Validator validator;

    @Autowired
    public UserController(UserService userService, @Qualifier("userRegistrationRequestValidator") Validator validator) {
        this.userService = userService;
        this.validator = validator;
    }


    @GetMapping("/cabinet")
    public String getCabinetPage(Model model, Authentication authentication) {
        if (Objects.isNull(authentication))
            return "login";
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User userToGet = userService.findByUsername(customUserDetails.getUsername()).get();
        model.addAttribute("user", userToGet);
        return "cabinet";
    }

    @GetMapping("/cabinet/edit")
    public String editUserProfile(Model model, Authentication authentication) {
        if (Objects.isNull(authentication))
            return "login";
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User userToGet = userService.findByUsername(customUserDetails.getUsername()).get();
        model.addAttribute("user", userToGet);
        return "editCabinet";
    }

    @PostMapping("/cabinet/edit")
    public String register(Model model, @ModelAttribute("user") @Validated User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "editCabinet";
        }

        if (!user.getFile().isEmpty()) {
            try {
                String photo = Base64.getEncoder().encodeToString(user.getFile().getBytes());
                userService.saveImage(photo, user.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        userService.updateUser(user);
        return "redirect:/cabinet";
    }

    @GetMapping("/allUsers")
    public String allUsers(Model model) {
        List<User> usersList = userService.findAll();
        model.addAttribute("users", usersList);
        return "usersList";
    }

}
