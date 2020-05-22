package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.home.JavaProject.domain.Faculty;
import ua.lviv.home.JavaProject.services.FacultyService;

import java.util.List;
import java.util.Optional;

@Controller
public class HomePageController {


    private FacultyService facultyService;

    @Autowired
    public HomePageController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public  String homePage(Model model){
        model.addAttribute("faculties", facultyService.findAll());
        return "home";
    }
}
