package pl.mariuszg95.spring.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mariuszg95.spring.data.model.Specialization;
import pl.mariuszg95.spring.data.repositories.SpecializationRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class SpecializationService {

    private SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public Set<Specialization> findAll() {
        return new HashSet<>(specializationRepository.findAll());
    }

    public Specialization getOne(Long id) {
        return specializationRepository.getOne(id);
    }
}
