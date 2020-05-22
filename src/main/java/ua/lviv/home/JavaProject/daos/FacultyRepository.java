package ua.lviv.home.JavaProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.home.JavaProject.domain.Faculty;

import java.util.Optional;

@Repository
@Transactional
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    @Modifying
    @Query("update Faculty f set f.name = :name where f.id=:id")
    void updateFacultyById(@Param("name") String name, @Param("id") int id);

}
