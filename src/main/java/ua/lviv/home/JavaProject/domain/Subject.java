package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private int id;

    private String name;

    @ManyToMany(mappedBy = "examSubjects")
    private Set<Faculty> faculties;

    public Subject() {
    }

    public Subject(String name, Set<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
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

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }
}
