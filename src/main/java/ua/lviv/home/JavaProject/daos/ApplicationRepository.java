package ua.lviv.home.JavaProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.home.JavaProject.domain.Applicant;
import ua.lviv.home.JavaProject.domain.Application;
import ua.lviv.home.JavaProject.domain.Speciality;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> findByApplicant(Applicant applicant);

    Optional<Application> findByApplicantAndSpeciality(Applicant applicant, Speciality speciality);
}