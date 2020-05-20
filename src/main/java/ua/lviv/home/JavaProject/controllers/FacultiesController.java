package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.lviv.home.JavaProject.domain.Faculty;
import ua.lviv.home.JavaProject.services.FacultyService;

import org.springframework.validation.Validator;

import java.util.Collections;
import java.util.List;

@Controller
public class FacultiesController {

    private final FacultyService facultyService;
    private final Validator validator;

    @Autowired
    public FacultiesController(FacultyService facultyService, @Qualifier("facultyValidator") Validator validator) {
        this.facultyService = facultyService;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping("/faculties/create")
    public String create(Model model) {
        model.addAttribute("facultyDto", new Faculty());
        List<Faculty> faculties = facultyService.findAll();
        model.addAttribute("faculties", faculties);
        return "createFaculty";
    }

    @PostMapping("/faculty/save")
    public String save(Model model, @ModelAttribute("facultyDto") @Validated Faculty faculty, BindingResult bindingResult) {
        if (checkIfErrorsExist(model, bindingResult, faculty)) {
            return "createFaculty";
        }
        facultyService.create(faculty);
        return "redirect:/faculties/create?success";
    }

    @GetMapping("/faculties/delete/{id}")
    public String delete(@PathVariable int id) {
        facultyService.deleteFaculty(id);
        return "redirect:/faculties/create";
    }

    @GetMapping("/faculties/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("facultyDto", new Faculty());

        Faculty facultyToEdit = facultyService.findFacultyById(id);
        model.addAttribute("faculty", Collections.singletonList(facultyToEdit));

        return "editFaculty";
    }

    @PostMapping("/faculties/save_edited")
    public String saveEdited(Model model, @ModelAttribute("facultyDto") @Validated Faculty faculty,
                             BindingResult bindingResult) {
        if (checkIfErrorsExist(model, bindingResult, faculty)) {
            return "createFaculty";
        }
        facultyService.updateFaculty(faculty.getId(),faculty.getName());
        return "redirect:/faculties/create?success";
    }

    private boolean checkIfErrorsExist(Model model, BindingResult bindingResult, Faculty faculty) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("facultyDto", faculty);
            List<Faculty> faculties = facultyService.findAll();
            model.addAttribute("faculties", faculties);
            return true;
        } else
            return false;
    }
}
