package pl.coderslab.visitsplanner.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.visitsplanner.model.Doctor;
import pl.coderslab.visitsplanner.model.Hospital;
import pl.coderslab.visitsplanner.model.Specialization;
import pl.coderslab.visitsplanner.repository.DoctorRepository;
import pl.coderslab.visitsplanner.repository.HospitalRepository;
import pl.coderslab.visitsplanner.repository.SpecialisationRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private ObjectMapper mapper;
    private DoctorRepository doctorRepository;
    private SpecialisationRepository specialisationRepository;
    private HospitalRepository hospitalRepository;

    public DoctorController(DoctorRepository doctorRepository, SpecialisationRepository specialisationRepository, HospitalRepository hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.specialisationRepository = specialisationRepository;
        this.hospitalRepository = hospitalRepository;
        this.mapper = new ObjectMapper();
    }

    @GetMapping("/add")
    public String doctorAddForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("specialisations", specialisationRepository.findAll());
        model.addAttribute("hospitals", hospitalRepository.findAll());
        return "doctors/add";
    }

    @PostMapping("/add")
    public String addDoctor(Doctor doctor,
                            @RequestParam(required = false) String jsonSpecialisation,
                            @RequestParam(required = false) String jsonHospital) {
        doctor.setPatients(new ArrayList<>());
        doctor.setHospitals(new ArrayList<>());

        if (jsonSpecialisation != null) {
            addNewSpecialisation(doctor, jsonSpecialisation);
        }

        if (jsonHospital != null) {
            addNewHospital(doctor, jsonHospital);
        }

        doctorRepository.save(doctor);
        return "redirect:/visit/showAll";
    }

    private void addNewSpecialisation(Doctor doctor, String jsonSpecialisation) {
        Specialization specialization = null;
        try {
            specialization = mapper.readValue(jsonSpecialisation, Specialization.class);
            specialisationRepository.save(specialization);
        } catch (JsonProcessingException e) {
            // TODO: obsługa błędu
            System.out.println(e.getMessage());
        }
        doctor.getSpecializations().add(specialization);
    }

    private void addNewHospital(Doctor doctor, String jsonHospital) {
        Hospital hospital = null;
        try {
            hospital = mapper.readValue(jsonHospital, Hospital.class);
            hospitalRepository.save(hospital);
        } catch (JsonProcessingException e) {
            // TODO: obsługa błędu
            System.out.println("ERROR");
        }
        doctor.getHospitals().add(hospital);
    }
}
