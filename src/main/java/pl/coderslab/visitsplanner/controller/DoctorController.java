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
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Set;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private ObjectMapper mapper;
    private DoctorRepository doctorRepository;
    private SpecialisationRepository specialisationRepository;
    private HospitalRepository hospitalRepository;
    private final Validator validator;

    public DoctorController(DoctorRepository doctorRepository, SpecialisationRepository specialisationRepository,
                            HospitalRepository hospitalRepository, Validator validator) {
        this.doctorRepository = doctorRepository;
        this.specialisationRepository = specialisationRepository;
        this.hospitalRepository = hospitalRepository;
        this.validator = validator;
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

        if (jsonSpecialisation != null) {
            doctor.setSpecializations(new ArrayList<>());
            Specialization specialization = addNewSpecialisation(jsonSpecialisation);
            if (specialization == null) {
                return "error";
            }
            doctor.getSpecializations().add(specialization);
        }

        if (jsonHospital != null) {
            doctor.setHospitals(new ArrayList<>());
            Hospital hospital = addNewHospital(jsonHospital);
            if (hospital == null) {
                return "error";
            }
            doctor.getHospitals().add(hospital);
        }

        Set<ConstraintViolation<Doctor>> violation = validator.validate(doctor);
        if (!violation.isEmpty()) {
            return "error";
        }
        doctorRepository.save(doctor);
        return "redirect:/visit/showAll";
    }

    private Specialization addNewSpecialisation(String jsonSpecialisation) {
        Specialization specialization = null;
        try {
            specialization = mapper.readValue(jsonSpecialisation, Specialization.class);
        } catch (JsonProcessingException e) {
            return null;
        }
        Set<ConstraintViolation<Specialization>> violations = validator.validate(specialization);
        if (!violations.isEmpty()) {
            return null;
        }
        specialisationRepository.save(specialization);
        return specialization;
    }

    private Hospital addNewHospital(String jsonHospital) {
        Hospital hospital = null;
        try {
            hospital = mapper.readValue(jsonHospital, Hospital.class);
        } catch (JsonProcessingException e) {
            return null;
        }
        Set<ConstraintViolation<Hospital>> violations = validator.validate(hospital);
        if (!violations.isEmpty()) {
            return null;
        }
        hospitalRepository.save(hospital);
        return hospital;
    }
}
