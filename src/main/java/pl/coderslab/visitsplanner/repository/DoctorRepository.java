package pl.coderslab.visitsplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.visitsplanner.model.Doctor;
import pl.coderslab.visitsplanner.model.Hospital;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d JOIN d.specializations s WHERE s.name = ?1")
    List<Doctor> findAllBySpecialisationName(String specialisation);

    @Query("SELECT h FROM Doctor d JOIN d.hospitals h WHERE d.id = ?1")
    List<Hospital> findAllHospitalsByDoctorId(Long doctorId);
}
