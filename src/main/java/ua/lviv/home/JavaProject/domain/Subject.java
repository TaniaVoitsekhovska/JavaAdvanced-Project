package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private int id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    public Subject() {
    }

    public Subject(String name) {
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
}
