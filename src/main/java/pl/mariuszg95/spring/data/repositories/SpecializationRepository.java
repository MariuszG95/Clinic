package pl.mariuszg95.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mariuszg95.spring.data.model.Specialization;

import java.util.Set;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

    Set<Specialization> getSpecializationByNameContains(String value);

    @Query(value = "SELECT doctor_id FROM doctors_specializations WHERE specialization_id = ?", nativeQuery = true)
    Long getDoctorId(Long specializationId);
}
