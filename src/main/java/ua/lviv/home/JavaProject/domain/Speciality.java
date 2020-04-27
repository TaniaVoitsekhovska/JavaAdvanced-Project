package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;

@Entity
@Table(name = "speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speciality_id")
    private int id;
    @Column
    private String title;
    @Column
    private int enrollmentPlan;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    public Speciality() {
    }

    public Speciality(String title, int enrollmentPlan) {
        this.title = title;
        this.enrollmentPlan = enrollmentPlan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEnrollmentPlan() {
        return enrollmentPlan;
    }

    public void setEnrollmentPlan(int enrollmentPlan) {
        this.enrollmentPlan = enrollmentPlan;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

}
