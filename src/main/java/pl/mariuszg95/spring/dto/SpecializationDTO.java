package pl.mariuszg95.spring.dto;

import pl.mariuszg95.spring.data.model.Specialization;

public class SpecializationDTO {

    private Long id;
    private String name;

    public SpecializationDTO(Specialization specialization) {
        this.id = specialization.getId();
        this.name = specialization.getName();
    }

    public Specialization getSpecialization() {
        Specialization specialization = new Specialization();
        specialization.setId(id);
        specialization.setName(name);

        return specialization;
    }

    @Override
    public String toString() {
        return "SpecializationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
