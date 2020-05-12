package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.home.JavaProject.domain.Subject;
import ua.lviv.home.JavaProject.services.SubjectService;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/create")
    public String create() {
        return "createSubjects";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Subject subject) {
        subjectService.create(subject);
        return "redirect:/subjects/create?success";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("subjects", subjectService.findAllSubjects());
        return "allSubjects";
    }
}
