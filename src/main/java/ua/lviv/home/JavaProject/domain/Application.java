package ua.lviv.home.JavaProject.domain;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "applicant_id", nullable = false)
    private Applicant applicant;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "marks")
    @MapKeyColumn(name = "subject_id")
    @Column(name = "mark")
    private Map<Subject, Integer> marks;


    @Column
    private int totalMark;


    public Application() {
    }

    public Application(Applicant applicant) {
        this.applicant = applicant;
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

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public Map<Subject, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<Subject, Integer> marks) {
        this.marks = marks;
    }
}
