package pl.coderslab.visitsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.visitsplanner.model.Patient;
import pl.coderslab.visitsplanner.repository.PatientRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/add")
    public String addPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patients/addPatient";
    }

    @PostMapping("/add")
    public String addPatient(@Valid Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "patients/addPatient";
        }
        patientRepository.save(patient);
        return "redirect:/";
    }

    @RequestMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("pateints", patientRepository.findAll());
        return "patients/showAll";
    }
}
