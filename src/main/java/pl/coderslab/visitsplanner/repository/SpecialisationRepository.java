package pl.coderslab.visitsplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.visitsplanner.model.Specialization;

public interface SpecialisationRepository extends JpaRepository<Specialization, Integer> {
    Specialization findByName(String name);
}
