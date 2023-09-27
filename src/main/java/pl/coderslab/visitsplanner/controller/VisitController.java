package pl.coderslab.visitsplanner.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pl.coderslab.visitsplanner.model.*;
import pl.coderslab.visitsplanner.repository.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;

@Controller
@RequestMapping("/visit")
public class VisitController {

    private ObjectMapper mapper;
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;
    private final SpecialisationRepository specialisationRepository;
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;
    private final Validator validator;

    public VisitController(VisitRepository visitRepository, PatientRepository patientRepository,
                           SpecialisationRepository specialisationRepository, DoctorRepository doctorRepository,
                           HospitalRepository hospitalRepository, Validator validator) {
        this.visitRepository = visitRepository;
        this.patientRepository = patientRepository;
        this.specialisationRepository = specialisationRepository;
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
        this.validator = validator;
        this.mapper = new ObjectMapper();
    }

    @RequestMapping("/showAll")
    public String showAllVisits(Model model) {
        model.addAttribute("visits", visitRepository.findAllOrderByDate());
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

    @GetMapping("/add/selectPatient")
    public String selectPatientForm(Model model) {
        model.addAttribute("visit", new Visit());
        model.addAttribute("patients", patientRepository.findAll());
        return "visits/selectPatient";
    }

    @PostMapping("/add/selectPatient")
    public String selectPatient(Visit visit, @RequestParam(required = false) String jsonPatient, Model model) {
        if (jsonPatient != null) {
            Patient patient = createPatient(jsonPatient);
            if (patient == null) {
                return "error";
            }
            visit.setPatient(patient);
        }
        model.addAttribute("visit", visit);
        model.addAttribute("specialisations", specialisationRepository.findAll());
        return "visits/selectSpecialisation";
    }

    @PostMapping("/add/selectSpecialisation")
    public String selectSpecialisation(Visit visit, @RequestParam(required = false) String jsonSpecialisation, Model model) {
        if (jsonSpecialisation != null) {
            Specialization specialization = createSpecialisation(jsonSpecialisation);
            if (specialization == null) {
                return "error";
            }
            visit.setSpecialisation(specialization.getName());
        }
        model.addAttribute("visit", visit);
        model.addAttribute("doctors", doctorRepository.findAllBySpecialisationName(visit.getSpecialisation()));
        return "visits/selectDoctor";
    }

    @PostMapping("/add/selectDoctor")
    public String selectDoctor(Visit visit, @RequestParam(required = false) String jsonDoctor, Model model) {
        if (jsonDoctor != null) {
            Doctor doctor = createDoctor(jsonDoctor, visit.getPatient(), visit.getSpecialisation());
            if (doctor == null) {
                return "error";
            }
            visit.setDoctor(doctor);
        } else {
            visit.getDoctor().getPatients().add(visit.getPatient());
            doctorRepository.save(visit.getDoctor());
        }
        model.addAttribute("visit", visit);
        model.addAttribute("hospitals", doctorRepository.findAllHospitalsByDoctorId(visit.getDoctor().getId()));
        return "visits/selectHospital";
    }

    @PostMapping("/add/selectHospital")
    public String selectHospital(Visit visit, @RequestParam(required = false) String jsonHospital, Model model) {
        if (jsonHospital != null) {
            Hospital hospital = createHospital(jsonHospital);
            if (hospital == null) {
                return "error";
            }
            visit.setHospital(hospital);
        }

        if (!visit.getDoctor().getHospitals().contains(visit.getHospital())) {
            visit.getDoctor().getHospitals().add(visit.getHospital());
            doctorRepository.save(visit.getDoctor());
        }
        model.addAttribute("visit", visit);
        return "visits/addDateAndComments";
    }

    @PostMapping("/add/createVisit")
    public RedirectView createVisit(Visit visit, @RequestParam String date, @RequestParam String time) {
        if (time.split(":")[0].length() == 1) {
            time = "0" + time;
        }
        LocalDateTime dateTime = LocalDateTime.parse(date + "T" + time);
        visit.setDateTime(dateTime);
        Set<ConstraintViolation<Visit>> violations = validator.validate(visit);
        if (!violations.isEmpty()) {
            return new RedirectView("/error");
        }
        visitRepository.save(visit);
        return new RedirectView("/");
    }

    private Patient createPatient(String jsonPatient) {
        Patient patient;
        try {
            patient = mapper.readValue(jsonPatient, Patient.class);
        } catch (JsonProcessingException e) {
            return null;
        }
        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);
        if (!violations.isEmpty()) {
            return null;
        }
        patientRepository.save(patient);
        return patient;
    }

    private Specialization createSpecialisation(String jsonSpecialisation) {
        Specialization specialisation;
        try {
            specialisation = mapper.readValue(jsonSpecialisation, Specialization.class);
        } catch (JsonProcessingException e) {
            return null;
        }
        Set<ConstraintViolation<Specialization>> violations = validator.validate(specialisation);
        if (!violations.isEmpty()) {
            return null;
        }
        specialisationRepository.save(specialisation);
        return specialisation;
    }

    private Doctor createDoctor(String jsonDoctor, Patient patient, String specName) {
        Doctor doctor;
        try {
            doctor = mapper.readValue(jsonDoctor, Doctor.class);
            doctor.getPatients().add(patient);
            doctor.getSpecializations().add(specialisationRepository.findByName(specName));
        } catch (JsonProcessingException e) {
            return null;
        }
        Set<ConstraintViolation<Doctor>> violations = validator.validate(doctor);
        if (!violations.isEmpty()) {
            return null;
        }
        doctorRepository.save(doctor);
        return doctor;
    }

    private Hospital createHospital(String jsonHospital) {
        Hospital hospital;
        try {
            hospital = mapper.readValue(jsonHospital, Hospital.class);
        } catch (JsonProcessingException e) {
            return null;
        }

        if (hospitalRepository.findHospitalByNameAndCity(hospital.getName(), hospital.getCity()) != null) {
            return hospitalRepository.findHospitalByNameAndCity(hospital.getName(), hospital.getCity());
        }

        Set<ConstraintViolation<Hospital>> violations = validator.validate(hospital);
        if (!violations.isEmpty()) {
            return null;
        }
        hospitalRepository.save(hospital);
        return hospital;
    }

    @GetMapping("/confirmDelete")
    public String confirmDelete(@RequestParam Long id, Model model) {
        Visit visit = visitRepository.findById(id).orElse(null);
        model.addAttribute("visit", visit);
        return "visits/confirmDelete";
    }

    @GetMapping("/delete")
    public RedirectView deleteVisit(@RequestParam Long id) {
        Visit visit = visitRepository.findById(id).orElse(null);
        visitRepository.delete(visit);
        return new RedirectView("/");
    }
}
