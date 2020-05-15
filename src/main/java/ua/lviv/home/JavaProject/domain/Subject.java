package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @Column(name = "max_grade")
    private int maxGrade;

    public Subject() {
    }

    public Subject(String name, int maxGrade) {
        this.name = name;
        this.maxGrade = maxGrade;
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

    public int getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(int maxGrade) {
        this.maxGrade = maxGrade;
    }
}
