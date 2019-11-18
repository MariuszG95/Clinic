package pl.mariuszg95.spring.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mariuszg95.spring.data.model.Doctor;
import pl.mariuszg95.spring.data.model.Specialization;
import pl.mariuszg95.spring.data.model.User;
import pl.mariuszg95.spring.data.repositories.DoctorRepository;
import pl.mariuszg95.spring.data.repositories.SpecializationRepository;
import pl.mariuszg95.spring.data.repositories.UserRepository;
import pl.mariuszg95.spring.dto.DoctorDTO;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class DoctorService {

    private DoctorRepository doctorRepository;
    private UserRepository userRepository;
    private SpecializationRepository specializationRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, UserRepository userRepository,
                         SpecializationRepository specializationRepository) {
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
        this.specializationRepository = specializationRepository;
    }

    public Doctor getById(Long id) {
        return doctorRepository.getById(id);
    }

    public Set<DoctorDTO> searchByFirstNameOrLastNameOrSpecialization(String query) {
        Set<DoctorDTO> foundDoctors = new HashSet<>();
        Set<User> matchingFirstName = userRepository.getUserByFirstNameContains(query);
        for (User user : matchingFirstName) {
            if (userRepository.getUserRole(user.getLogin()).equals("ROLE_DOCTOR")) {
                foundDoctors.add(new DoctorDTO(doctorRepository.getById(doctorRepository.getDoctorId(user.getId()))));
            }
        }
        Set<User> matchingLastName = userRepository.getUserByLastNameContains(query);
        for (User user : matchingLastName) {
            if (userRepository.getUserRole(user.getLogin()).equals("ROLE_DOCTOR")) {
                foundDoctors.add(new DoctorDTO(doctorRepository.getById(doctorRepository.getDoctorId(user.getId()))));
            }
        }
        Set<Specialization> matchingSpecializations = specializationRepository.getSpecializationByNameContains(query);
        for (Specialization specialization : matchingSpecializations) {
            foundDoctors.add(new DoctorDTO(doctorRepository.getById(specializationRepository.getDoctorId(specialization.getId()))));
        }

        return foundDoctors;
    }
}
