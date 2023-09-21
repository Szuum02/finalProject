package pl.coderslab.visitsplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.visitsplanner.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
