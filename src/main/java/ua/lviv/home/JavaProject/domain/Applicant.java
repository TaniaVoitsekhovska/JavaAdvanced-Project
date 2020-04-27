package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "applicant", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User applicant;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "speciality_applicant", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> applicantSpecialities;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "applicant")
    @Column(nullable = false)
    private Set<Application> applications;


    public Applicant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Speciality> getApplicantSpecialities() {
        return applicantSpecialities;
    }

    public void setApplicantSpecialities(Set<Speciality> applicantSpecialities) {
        this.applicantSpecialities = applicantSpecialities;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }
}
