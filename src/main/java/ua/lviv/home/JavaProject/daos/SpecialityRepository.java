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
import java.util.Set;

@Repository
@Transactional
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {

    @Modifying
    @Query("update Speciality s set s.title = :title where s.id=:id")
    void updateSpecialityById(@Param("title") String title, @Param("id") int id);

    @Modifying
    @Query("delete from Speciality s where s.id=:id")
    void deleteSubjects(@Param("id") int id);
}
