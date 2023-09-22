package pl.coderslab.visitsplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.visitsplanner.model.Doctor;
import pl.coderslab.visitsplanner.repository.DoctorRepository;
import pl.coderslab.visitsplanner.repository.HospitalRepository;
import pl.coderslab.visitsplanner.repository.SpecialisationRepository;

import java.util.ArrayList;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private DoctorRepository doctorRepository;
    private SpecialisationRepository specialisationRepository;
    private HospitalRepository hospitalRepository;

    public DoctorController(DoctorRepository doctorRepository, SpecialisationRepository specialisationRepository, HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.specialisationRepository = specialisationRepository;
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/add")
    public String doctorAddForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("specialisations", specialisationRepository.findAll());
        model.addAttribute("hospitals", hospitalRepository.findAll());
        return "doctors/add";
    }

    @PostMapping("/add")
    public String addDoctor(Doctor doctor) {
        doctor.setPatients(new ArrayList<>());
        doctorRepository.save(doctor);
        return "redirect:/visit/showAll";
    }
}
