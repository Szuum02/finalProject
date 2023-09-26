package pl.coderslab.visitsplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.visitsplanner.model.Patient;
import pl.coderslab.visitsplanner.model.Specialization;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT DISTINCT s FROM Patient p " +
            "JOIN p.doctors d " +
            "JOIN d.specializations s " +
            "WHERE p.id = :patientId")
    List<Specialization> findAllSpecialisation(Long patientId);
}
