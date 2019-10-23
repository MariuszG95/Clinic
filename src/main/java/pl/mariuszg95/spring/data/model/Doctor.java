package pl.mariuszg95.spring.data.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int room;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "doctors_users",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "specialization_id"))
    private Set<User> doctorSpecializations = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "doctors_users",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> doctorUsers = new HashSet<>();

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

    public Set<User> getDoctorSpecializations() {
        return doctorSpecializations;
    }

    public void setDoctorSpecializations(Set<User> doctorSpecializations) {
        this.doctorSpecializations = doctorSpecializations;
    }

    public Set<User> getDoctorUsers() {
        return doctorUsers;
    }

    public void setDoctorUsers(Set<User> doctorUsers) {
        this.doctorUsers = doctorUsers;
    }
}
