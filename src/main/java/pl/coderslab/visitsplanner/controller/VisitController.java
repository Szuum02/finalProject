package pl.coderslab.visitsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.visitsplanner.model.Visit;
import pl.coderslab.visitsplanner.repository.PatientRepository;
import pl.coderslab.visitsplanner.repository.VisitRepository;

@Controller
@RequestMapping("/visit")
public class VisitController {
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;

    public VisitController(VisitRepository visitRepository, PatientRepository patientRepository) {
        this.visitRepository = visitRepository;
        this.patientRepository = patientRepository;
    }

    @RequestMapping("/showAll")
    public String showAllVisits(Model model) {
        model.addAttribute("visits", visitRepository.findAll());
        return "visits/showAll";
    }

    @RequestMapping("/details")
    public String showDetails(@RequestParam Long id, Model model) {
        Visit visit = visitRepository.findById(id).orElse(null);
        if (visit == null) {
            return "redirect:showAll";
        }
        model.addAttribute("visit", visit);
        return "visits/visitsDetails";
    }

    @GetMapping("/add")
    public String addVisitForm(Model model) {
        model.addAttribute("visit", new Visit());
        model.addAttribute("patients", patientRepository.findAll());
        return "visits/add";
    }
}
