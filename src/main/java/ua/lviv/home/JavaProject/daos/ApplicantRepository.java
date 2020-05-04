package ua.lviv.home.JavaProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.home.JavaProject.domain.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
}
