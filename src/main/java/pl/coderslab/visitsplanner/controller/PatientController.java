package pl.coderslab.visitsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.visitsplanner.model.Patient;
import pl.coderslab.visitsplanner.repository.PatientRepository;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/addPatient")
    public String addPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patients/addPatient";
    }

    @PostMapping("/addPatient")
    public String addPatient(Patient patient) {
        patientRepository.save(patient);
        return "redirect:/patient/showAll";
    }

    @RequestMapping("/showAll")
    public String showAll(Model model) {
        model.addAttribute("pateints", patientRepository.findAll());
        return "patients/showAll";
    }
}
