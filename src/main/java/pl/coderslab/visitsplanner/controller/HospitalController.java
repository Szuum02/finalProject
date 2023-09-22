package pl.coderslab.visitsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.visitsplanner.model.Hospital;
import pl.coderslab.visitsplanner.repository.HospitalRepository;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
    private HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/add")
    public String hospitalAddForm(Model model) {
        model.addAttribute("hospital", new Hospital());
        return "hospitals/add";
    }

    @PostMapping("/add")
    public String addHospital(Hospital hospital) {
        hospitalRepository.save(hospital);
        return "redirect:/visit/showAll";
    }
}
