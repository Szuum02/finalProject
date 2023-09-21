package pl.coderslab.visitsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.visitsplanner.model.Visit;
import pl.coderslab.visitsplanner.repository.VisitRepository;

@Controller
@RequestMapping("/visit")
public class VisitController {
    private final VisitRepository visitRepository;

    public VisitController(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
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
}
