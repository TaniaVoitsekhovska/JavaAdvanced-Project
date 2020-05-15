package ua.lviv.home.JavaProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.home.JavaProject.domain.Speciality;

import java.util.Optional;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,Integer> {

    Optional<Speciality> findByTitle(String title);

}
