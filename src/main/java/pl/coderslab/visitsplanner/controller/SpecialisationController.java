package pl.coderslab.visitsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.visitsplanner.model.Specialization;
import pl.coderslab.visitsplanner.repository.SpecialisationRepository;

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
    public String addSpecialisation(Specialization specialization) {
        specialisationRepository.save(specialization);
        return "redirect:/visit/showAll";
    }
}
