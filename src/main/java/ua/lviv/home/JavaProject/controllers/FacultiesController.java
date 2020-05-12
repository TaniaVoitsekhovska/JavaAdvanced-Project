package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.home.JavaProject.dtos.FacultyRegisterRequest;
import ua.lviv.home.JavaProject.services.FacultyService;

@Controller
@RequestMapping("/faculties")
public class FacultiesController {

    private final FacultyService facultyService;

    @Autowired
    public FacultiesController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/create")
    public String create() {
        return "createFaculty";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute FacultyRegisterRequest facultyRegisterRequest) {
        facultyService.create(facultyRegisterRequest);
        return "redirect:/faculties/create?success";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("faculties", facultyService.findAll());
        return "allFaculties";
    }
}
