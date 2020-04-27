package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speciality_id")
    private Integer id;
    @Column
    private String title;
    @Column
    private Integer enrollmentPlan;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @ManyToMany(mappedBy = "applicantSpecialities")
    private Set<Applicant> applicants;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "speciality")
    @Column(nullable = false)
    private Set<Application> applications;


    public Speciality() {	}

    public Speciality(String title, Integer enrollmentPlan) {
        this.title = title;
        this.enrollmentPlan = enrollmentPlan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEnrollmentPlan() {
        return enrollmentPlan;
    }

    public void setEnrollmentPlan(Integer enrollmentPlan) {
        this.enrollmentPlan = enrollmentPlan;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Set<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(Set<Applicant> applicants) {
        this.applicants = applicants;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

}
