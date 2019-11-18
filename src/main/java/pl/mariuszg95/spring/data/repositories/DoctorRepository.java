package pl.mariuszg95.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mariuszg95.spring.data.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor getById(Long id);

    @Query(value = "SELECT doctor_id FROM doctors_users WHERE user_id = ?", nativeQuery = true)
    Long getDoctorId(Long userId);
}
