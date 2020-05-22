package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.home.JavaProject.domain.*;
import ua.lviv.home.JavaProject.services.*;

import java.util.Objects;

@Controller
public class ApplicationController {

    private final ApplicationService applicationService;
    private final UserService userService;
    private final FacultyService facultyService;
    private final SpecialityService specialityService;
    private final SubjectService subjectService;

    @Autowired
    public ApplicationController(ApplicationService applicationService, UserService userService,
                                 FacultyService facultyService, SpecialityService specialityService,
                                 SubjectService subjectService) {
        this.applicationService = applicationService;
        this.userService = userService;
        this.facultyService = facultyService;
        this.specialityService = specialityService;
        this.subjectService = subjectService;
    }


    @GetMapping("/apply/speciality/{id}")
    public String apply(Model model, @PathVariable int id){
        model.addAttribute("speciality", specialityService.findById(id));
        model.addAttribute("subjects", specialityService.findById(id).getSubjects());
        return "application";
    }
    @GetMapping("/apply")
    public String create(Model model) {
        model.addAttribute("application", new Application());
        model.addAttribute("specialities", specialityService.findAllSpecialities());
        return "apply";
    }


    @PostMapping("/apply")
    public String addApplication(Model model, Authentication authentication,
                                 @ModelAttribute("application") Application application) {
        if (Objects.isNull(authentication))
            return "login";
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User userToGet = userService.findByUsername(customUserDetails.getUsername()).get();
        model.addAttribute("specialities", specialityService.findAllSpecialities());
        application.setUser(userService.findById(userToGet.getId()));
        applicationService.save(application);

        return "redirect:/";
    }
}
