package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "application")
@Inheritance(strategy = InheritanceType.JOINED)
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "zno_marks")
    @MapKeyColumn(name = "subject_id")
    private Map<Subject, Integer> znoMarks;

    @Column
    private int attMark;


    public Application() {	}

    public Application(Applicant applicant, Speciality speciality, Map<Subject, Integer> znoMarks, int attMark) {
        this.applicant = applicant;
        this.speciality = speciality;
        this.znoMarks = znoMarks;
        this.attMark = attMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Map<Subject, Integer> getZnoMarks() {
        return znoMarks;
    }

    public void setZnoMarks(Map<Subject, Integer> znoMarks) {
        this.znoMarks = znoMarks;
    }

    public int getAttMark() {
        return attMark;
    }

    public void setAttMark(int attMark) {
        this.attMark = attMark;
    }
}
