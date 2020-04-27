package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "faculties")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subject_of_faculty", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> examSubjects;

    public Faculty() {
    }

    public Faculty(String name) {
        this.name = name;
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

    public Set<Subject> getExamSubjects() {
        return examSubjects;
    }

    public void setExamSubjects(Set<Subject> examSubjects) {
        this.examSubjects = examSubjects;
    }
}
