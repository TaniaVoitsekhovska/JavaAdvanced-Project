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
import ua.lviv.home.JavaProject.domain.Speciality;
import ua.lviv.home.JavaProject.domain.Subject;
import ua.lviv.home.JavaProject.services.SpecialityService;
import ua.lviv.home.JavaProject.services.SubjectService;

import java.util.*;

@Controller
public class SpecialityController {

    private final SpecialityService specialityService;
    private final SubjectService subjectService;
    private final Validator validator;

    @Autowired
    public SpecialityController(SpecialityService specialityService,
                                SubjectService subjectService,
                                @Qualifier("specialityValidator") Validator validator
    ) {
        this.specialityService = specialityService;
        this.subjectService = subjectService;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping("/specialities/create")
    public String create(Model model) {
        model.addAttribute("specialityDto", new Speciality());
        model.addAttribute("specialities", specialityService.findAllSpecialities());
        model.addAttribute("subjects", subjectService.findAllSubjects());
        return "createSpeciality";
    }

    @PostMapping("/specialities/save")
    public String save(Model model, @ModelAttribute("specialityDto") @Validated Speciality speciality,
                       BindingResult bindingResult,
                       @RequestParam("subjects") List<Subject> subjectsIds) {

        if (checkIfErrorsExist(model, bindingResult, speciality)) {
            return "createSpeciality";
        }
        Integer grade = 0;
        for (Subject sub : speciality.getSubjects()) {
            grade += sub.getMaxGrade();
        }
        speciality.setTotalGrade(grade);
        specialityService.save(speciality, subjectsIds);
        return "redirect:/specialities/create?success";
    }

    @GetMapping("/specialities/delete/{id}")
    public String delete(@PathVariable int id) {
        specialityService.delete(id);
        return "redirect:/specialities/create";
    }

    @GetMapping("/specialities/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("specialityDto", new Speciality());

        Speciality specialityToEdit = specialityService.findById(id);
        Integer grade1 = 0;
        for (Subject sub : specialityToEdit.getSubjects()) {
            grade1 += sub.getMaxGrade();
        }
        specialityToEdit.setTotalGrade(grade1);
        model.addAttribute("speciality", Arrays.asList(specialityToEdit));
        model.addAttribute("subjectIds", specialityToEdit.getSubjects());
        model.addAttribute("subjects", subjectService.findAllSubjects());
        return "editSpecialit";
    }

    @PostMapping("/specialities/save_edited")
    public String saveEdited(Model model, @ModelAttribute("specialityDto") @Validated Speciality speciality,
                             BindingResult bindingResult, @RequestParam("subjectIds") List<Subject> subjectsIds) {



        if (checkIfErrorsExist(model, bindingResult, speciality)) {
            return "createSpeciality";
        }

        specialityService.deleteAllSubjects(speciality.getId());
        Integer grade = 0;
        Iterator<Subject> iterator=subjectsIds.iterator();
        while (iterator.hasNext()){
            grade+=iterator.next().getMaxGrade();
        }

        speciality.setTotalGrade(grade);
        specialityService.save(speciality, subjectsIds);

        return "redirect:/specialities/create?success";
    }


    private boolean checkIfErrorsExist(Model model, BindingResult bindingResult, Speciality speciality) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("specialityDto", speciality);
            List<Speciality> specialities = specialityService.findAllSpecialities();
            model.addAttribute("specialities", specialities);
            model.addAttribute("subjects", subjectService.findAllSubjects());
            return true;
        } else
            return false;
    }

}
