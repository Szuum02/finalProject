package pl.coderslab.visitsplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.visitsplanner.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Hospital findHospitalByNameAndCity(String name, String city);
}
