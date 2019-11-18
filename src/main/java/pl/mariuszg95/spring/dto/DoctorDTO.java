package pl.mariuszg95.spring.dto;

import pl.mariuszg95.spring.data.model.Doctor;
import pl.mariuszg95.spring.data.model.Specialization;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DoctorDTO {

    private Long id;
    private int room;
    private Set<SpecializationDTO> specializations = new HashSet<>();
    private UserDTO userDTO;

    public DoctorDTO(Doctor doctor) {
        this.id = doctor.getId();
        this.room = doctor.getRoom();
        Iterator<Specialization> iterator = doctor.getrSpecializations().iterator();
        while (iterator.hasNext()) {
            specializations.add(new SpecializationDTO(iterator.next()));
        }
        this.userDTO = new UserDTO(doctor.getUser());
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", room=" + room +
                ", specializations=" + specializations +
                ", userDTO=" + userDTO +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Set<SpecializationDTO> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(Set<SpecializationDTO> specializations) {
        this.specializations = specializations;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
