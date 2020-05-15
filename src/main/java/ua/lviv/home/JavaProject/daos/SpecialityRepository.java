package ua.lviv.home.JavaProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.lviv.home.JavaProject.domain.Speciality;
import ua.lviv.home.JavaProject.domain.Subject;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,Integer> {

    Optional<Speciality> findByTitle(String title);

    @Query("select s.subjects from Speciality s where s.title = :title")
    Set<Subject> findAllSubjectsBySpecialityTitle(@Param("title")String title);

}
