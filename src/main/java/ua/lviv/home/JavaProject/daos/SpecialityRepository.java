package ua.lviv.home.JavaProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.home.JavaProject.domain.Speciality;
import ua.lviv.home.JavaProject.domain.Subject;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface SpecialityRepository extends JpaRepository<Speciality,Integer> {

    Optional<Speciality> findByTitle(String title);

    @Modifying
    @Query("update Speciality s set s.title = :title, s.enrollmentPlan=:enrollmentPlan where s.id=:id")
    void updateSpecialityById(@Param("title") String title, @Param("enrollmentPlan") int enrollmentPlan,
                              @Param("id") int id);

    @Modifying
    @Query("update Speciality s set s.subjects = :subjects where s.id=:id")
    void updateSpecialityByIdSetSubjects(@Param("subjects")List<Subject> subjects, @Param("id") int id);
}
