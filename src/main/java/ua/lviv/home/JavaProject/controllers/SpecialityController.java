package ua.lviv.home.JavaProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.home.JavaProject.domain.Speciality;
import ua.lviv.home.JavaProject.services.SpecialityService;

import java.util.List;

@Controller
public class SpecialityController {

    private final SpecialityService specialityService;
    @Autowired
    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping("/specialities/create")
    public String create(Model model) {
        model.addAttribute("speciality", new Speciality());
        List<Speciality> specialities=specialityService.findAllSpecialities();
        model.addAttribute("specialities", specialities);
        return "createSpeciality";
    }

    @PostMapping("/specialities/save")
    public String save(Model model,@ModelAttribute("speciality") Speciality speciality) {
        model.addAttribute("speciality",speciality);
        specialityService.save(speciality);
        return "redirect:/specialities/create?success";
    }
}
