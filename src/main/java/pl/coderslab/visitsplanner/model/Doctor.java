package pl.coderslab.visitsplanner.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Pattern(regexp = "(\\p{L}*[- ])*\\p{L}+", message = "Błędne imię")
    private String firstName;
    @NotNull
    @NotBlank
    @Pattern(regexp = "(\\p{L}*[- ])*\\p{L}+", message = "Błędne nazwisko")
    private String lastName;

    @ManyToMany
    @NotNull(message = "Należy wskazać specjalizacje")
    private List<Specialization> specializations = new ArrayList<>();

    @ManyToMany
    private List<Patient> patients = new ArrayList<>();

    @ManyToMany
    private List<Hospital> hospitals = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Specialization> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Specialization> specializations) {
        this.specializations = specializations;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public String getSpecializationsNames() {
        return specializations.stream()
                .map(s -> s.getName())
                .collect(Collectors.joining(", "));
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}