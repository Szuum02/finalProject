package pl.coderslab.visitsplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.visitsplanner.model.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
