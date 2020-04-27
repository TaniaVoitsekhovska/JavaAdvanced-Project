package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "applicant")
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "applicant_speciality")
    @MapKeyColumn(name = "speciality_id")
    private Map<Speciality, User> specialityUserMap;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "applicant")
    @Column
    private Set<Application> applications;


    public Applicant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Application> getApplications() {
        return applications;
    }

    public void setApplications(Set<Application> applications) {
        this.applications = applications;
    }

    public Map<Speciality, User> getSpecialityUserMap() {
        return specialityUserMap;
    }

    public void setSpecialityUserMap(Map<Speciality, User> specialityUserMap) {
        this.specialityUserMap = specialityUserMap;
    }
}
