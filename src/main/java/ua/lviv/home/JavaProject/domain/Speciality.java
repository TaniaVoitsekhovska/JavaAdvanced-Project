package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(unique=true)
    private String title;

    @Column(name = "enrollment_plan")
    private int enrollmentPlan;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "subject_speciality")
    @MapKeyColumn(name = "subject_id")
    private Set<Subject> subjects;

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

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
