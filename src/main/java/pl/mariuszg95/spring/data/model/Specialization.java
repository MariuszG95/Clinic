package pl.mariuszg95.spring.data.model;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Specialization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String specialization;
}
