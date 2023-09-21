package pl.coderslab.visitsplanner.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "specializations")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private SpecializationsNames name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SpecializationsNames getName() {
        return name;
    }

    public void setName(SpecializationsNames name) {
        this.name = name;
    }
}
