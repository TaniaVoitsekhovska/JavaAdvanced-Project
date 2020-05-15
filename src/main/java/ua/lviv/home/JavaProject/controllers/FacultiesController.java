package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.home.JavaProject.domain.Faculty;
import ua.lviv.home.JavaProject.services.FacultyService;

import java.util.List;

@Controller
@RequestMapping("/faculties")
public class FacultiesController {

    private final FacultyService facultyService;

    @Autowired
    public FacultiesController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("faculty", new Faculty());
        List<Faculty> faculties = facultyService.findAll();
        model.addAttribute("faculties",faculties );
        return "createFaculty";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Faculty faculty) {
        facultyService.create(faculty);
        return "redirect:/faculties/create?success";
    }

    @GetMapping("/all")
    public String all(Model model) {

        return "allFaculties";
    }
}
