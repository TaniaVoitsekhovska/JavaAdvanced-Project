package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @OneToOne
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;

    @Column(name = "registration_date")
    private Timestamp date;

    public Applicant() {
    }

    public Applicant(User user, Faculty faculty, Speciality speciality, Timestamp date) {
        this.user = user;
        this.faculty = faculty;
        this.speciality = speciality;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
