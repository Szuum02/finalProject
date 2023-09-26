package pl.coderslab.visitsplanner.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pl.coderslab.visitsplanner.model.*;
import pl.coderslab.visitsplanner.repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Controller
@RequestMapping("/visit")
public class VisitController {

    private ObjectMapper mapper;
    private final VisitRepository visitRepository;
    private final PatientRepository patientRepository;
    private final SpecialisationRepository specialisationRepository;
    private final DoctorRepository doctorRepository;
    private final HospitalRepository hospitalRepository;

    public VisitController(VisitRepository visitRepository, PatientRepository patientRepository,
                           SpecialisationRepository specialisationRepository, DoctorRepository doctorRepository,
                           HospitalRepository hospitalRepository) {
        this.visitRepository = visitRepository;
        this.patientRepository = patientRepository;
        this.specialisationRepository = specialisationRepository;
        this.doctorRepository = doctorRepository;
        this.hospitalRepository = hospitalRepository;
        this.mapper = new ObjectMapper();
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

    @GetMapping("/add/selectPatient")
    public String selectPatientForm(Model model) {
        model.addAttribute("visit", new Visit());
        model.addAttribute("patients", patientRepository.findAll());
        return "visits/selectPatient";
    }

    @PostMapping("/add/selectPatient")
    public String selectPatient(Visit visit, @RequestParam(required = false) String jsonPatient, Model model) {
        if (jsonPatient != null) {
            visit.setPatient(createPatient(jsonPatient));
        }
        model.addAttribute("visit", visit);
        model.addAttribute("specialisations", specialisationRepository.findAll());
        return "visits/selectSpecialisation";
    }

    @PostMapping("/add/selectSpecialisation")
    public String selectSpecialisation(Visit visit, @RequestParam(required = false) String jsonSpecialisation, Model model) {
        if (jsonSpecialisation != null) {
            visit.setSpecialisation(createSpecialisation(jsonSpecialisation).getName());
        }
        model.addAttribute("visit", visit);
        model.addAttribute("doctors", doctorRepository.findAllBySpecialisationName(visit.getSpecialisation()));
        return "visits/selectDoctor";
    }

    @PostMapping("/add/selectDoctor")
    public String selectDoctor(Visit visit, @RequestParam(required = false) String jsonDoctor, Model model) {
        if (jsonDoctor != null) {
            visit.setDoctor(createDoctor(jsonDoctor, visit.getPatient(), visit.getSpecialisation()));
        }
        model.addAttribute("visit", visit);
        model.addAttribute("hospitals", doctorRepository.findAllHospitalsByDoctorId(visit.getDoctor().getId()));
        return "visits/selectHospital";
    }

    @PostMapping("/add/selectHospital")
    public String selectHospital(Visit visit, @RequestParam(required = false) String jsonHospital, Model model) {
        if (jsonHospital != null) {
            visit.setHospital(createHospital(jsonHospital));
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
        visitRepository.save(visit);
        return new RedirectView("/visit/showAll");
    }

    private Patient createPatient(String jsonPatient) {
        Patient patient = null;
        try {
            patient = mapper.readValue(jsonPatient, Patient.class);
            patientRepository.save(patient);
        } catch (JsonProcessingException e) {
            //TODO
            System.out.println(e);
        }
        return patient;
    }

    private Specialization createSpecialisation(String jsonSpecialisation) {
        Specialization specialisation = null;
        try {
            specialisation = mapper.readValue(jsonSpecialisation, Specialization.class);
            specialisationRepository.save(specialisation);
        } catch (JsonProcessingException e) {
            // TODO: obsługa błędu
            System.out.println(e.getMessage());
        }
        return specialisation;
    }

    private Doctor createDoctor(String jsonDoctor, Patient patient, String specName) {
        Doctor doctor = null;
        try {
            doctor = mapper.readValue(jsonDoctor, Doctor.class);
            doctor.setPatients(new ArrayList<>());
            doctor.getPatients().add(patient);
            doctor.setSpecializations(new ArrayList<>());
            doctor.getSpecializations().add(specialisationRepository.findByName(specName));
            doctorRepository.save(doctor);
        } catch (JsonProcessingException e) {
            //TODO
            System.out.println(e.getMessage());
        }
        return doctor;
    }

    private Hospital createHospital(String jsonHospital) {
        Hospital hospital = null;
        try {
            hospital = mapper.readValue(jsonHospital, Hospital.class);
            if (hospitalRepository.findHospitalByNameAndCity(hospital.getName(), hospital.getCity()) == null) {
                hospitalRepository.save(hospital);
            } else {
                hospital = hospitalRepository.findHospitalByNameAndCity(hospital.getName(), hospital.getCity());
            }
        } catch (JsonProcessingException e) {
            //TODO
            System.out.println(e.getMessage());
        }
        return hospital;
    }
}
