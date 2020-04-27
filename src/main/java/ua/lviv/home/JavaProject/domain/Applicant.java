package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "speciality_applicant", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> applicantSpecialities;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "applicant")
    @Column(nullable = false)
    private Set<Application> applications;


    public Applicant() {
    }


}
