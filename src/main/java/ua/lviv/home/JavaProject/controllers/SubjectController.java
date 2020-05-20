package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.lviv.home.JavaProject.domain.Subject;
import ua.lviv.home.JavaProject.services.SubjectService;

import java.util.Collections;
import java.util.List;


@Controller
public class SubjectController {

    private final SubjectService subjectService;
    private final Validator validator;

    @Autowired
    public SubjectController(SubjectService subjectService, @Qualifier("subjectValidator") Validator validator) {
        this.subjectService = subjectService;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping("/subjects/create")
    public String create(Model model) {
        model.addAttribute("subjectDto", new Subject());
        List<Subject> subjects = subjectService.findAllSubjects();
        model.addAttribute("subjects", subjects);
        return "createSubjects";
    }

    @PostMapping("/subjects/save")
    public String save(Model model, @ModelAttribute("subjectDto") @Validated Subject subject,
                       BindingResult bindingResult) {
        if (checkIfErrorsExist(model, bindingResult, subject)) {
            return "createSubjects";
        }
        subjectService.save(subject);
        return "redirect:/subjects/create?success";
    }

    @PostMapping("/subjects/save_edited")
    public String saveEdited(Model model, @ModelAttribute("subjectDto") @Validated Subject subject,
                             BindingResult bindingResult) {
        if (checkIfErrorsExist(model, bindingResult, subject)) {
            return "createSubjects";
        }
        subjectService.updateSubject(subject.getName(), subject.getMaxGrade(), subject.getId());
        return "redirect:/subjects/create?success";
    }

    @GetMapping("/subjects/delete/{id}")
    public String delete(@PathVariable int id) {
        subjectService.deleteSubjectById(id);
        return "redirect:/subjects/create";
    }

    @GetMapping("/subjects/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("subjectDto", new Subject());

        Subject subjectToEdit = subjectService.findSubjectById(id);
        model.addAttribute("subject", Collections.singletonList(subjectToEdit));

        return "editSubject";
    }

    private boolean checkIfErrorsExist(Model model, BindingResult bindingResult, Subject subject) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("subjectDto", subject);
            List<Subject> subjects = subjectService.findAllSubjects();
            model.addAttribute("subjects", subjects);
            return true;
        } else
            return false;
    }
}
