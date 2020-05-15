package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.home.JavaProject.domain.Subject;
import ua.lviv.home.JavaProject.services.SubjectService;

import java.util.List;


@Controller
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects/create")
    public String create(Model model) {
        model.addAttribute("subjectDto", new Subject());
        List<Subject> subjects= subjectService.findAllSubjects();
        model.addAttribute("subjects",subjects);
        return "createSubjects";
    }

    @PostMapping("/subjects/save")
    public String save(Model model,@ModelAttribute("subjectDto") Subject subject) {
        model.addAttribute("subjectDto",subject);
        subjectService.save(subject);
        return "redirect:/subjects/create";
    }
}
