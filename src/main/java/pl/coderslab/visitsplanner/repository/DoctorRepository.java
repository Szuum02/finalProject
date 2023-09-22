package pl.coderslab.visitsplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.visitsplanner.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
