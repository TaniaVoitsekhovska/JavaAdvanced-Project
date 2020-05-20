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
import ua.lviv.home.JavaProject.services.SpecialityService;

import java.util.Collections;
import java.util.List;

@Controller
public class SpecialityController {

    private final SpecialityService specialityService;
    private final Validator validator;

    @Autowired
    public SpecialityController(SpecialityService specialityService,
                                @Qualifier("specialityValidator") Validator validator) {
        this.specialityService = specialityService;
        this.validator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping("/specialities/create")
    public String create(Model model) {
        model.addAttribute("specialityDto", new Speciality());
        List<Speciality> specialities = specialityService.findAllSpecialities();
        model.addAttribute("specialities", specialities);
        return "createSpeciality";
    }

    @PostMapping("/specialities/save")
    public String save(Model model, @ModelAttribute("specialityDto") @Validated Speciality speciality,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("specialityDto", speciality);
            List<Speciality> specialities = specialityService.findAllSpecialities();
            model.addAttribute("specialities", specialities);
            return "createSpeciality";
        }
        specialityService.save(speciality);
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
        model.addAttribute("speciality", Collections.singletonList(specialityToEdit));

        return "editSpecialit";
    }

    @PostMapping("/specialities/save_edited")
    public String saveEdited(Model model, @ModelAttribute("specialityDto") @Validated Speciality speciality,
                             BindingResult bindingResult) {
        if (checkIfErrorsExist(model, bindingResult, speciality)) {
            return "createSpeciality";
        }
        specialityService.update(speciality.getTitle(), speciality.getEnrollmentPlan(), speciality.getId());
        return "redirect:/specialities/create?success";
    }


    private boolean checkIfErrorsExist(Model model, BindingResult bindingResult, Speciality speciality) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("specialityDto", speciality);
            List<Speciality> specialities = specialityService.findAllSpecialities();
            model.addAttribute("specialities", specialities);
            return true;
        } else
            return false;
    }
}
