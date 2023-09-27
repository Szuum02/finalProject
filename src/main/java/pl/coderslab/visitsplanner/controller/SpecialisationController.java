package pl.coderslab.visitsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.visitsplanner.model.Specialization;
import pl.coderslab.visitsplanner.repository.SpecialisationRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/specialisation")
public class SpecialisationController {
    private SpecialisationRepository specialisationRepository;

    public SpecialisationController(SpecialisationRepository specialisationRepository) {
        this.specialisationRepository = specialisationRepository;
    }

    @GetMapping("/add")
    public String specialisationForm(Model model) {
        model.addAttribute("specialisation", new Specialization());
        return "specialisations/add";
    }

    @PostMapping("/add")
    public String addSpecialisation(@ModelAttribute("specialisation") @Valid Specialization specialisation, BindingResult result) {
        if (result.hasErrors()) {
            return "specialisations/add";
        }
        specialisationRepository.save(specialisation);
        return "redirect:/visit/showAll";
    }
}
