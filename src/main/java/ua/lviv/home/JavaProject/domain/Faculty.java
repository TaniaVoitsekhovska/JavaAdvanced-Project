package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Column(unique=true)
    private String name;

    @ManyToMany
    @JoinTable(name = "faculty_specialities",
            joinColumns = @JoinColumn(name = "faculty_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private List<Speciality> specialities;


    public Faculty() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }
}
