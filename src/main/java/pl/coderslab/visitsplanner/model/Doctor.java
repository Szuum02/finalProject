package pl.coderslab.visitsplanner.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @ManyToMany
    @NotNull
    private List<Specialization> specializations;

    @ManyToMany
    @NotNull
    private List<Patient> patients;

    @ManyToMany
    @NotNull
    private List<Hospital> hospitals;
}
