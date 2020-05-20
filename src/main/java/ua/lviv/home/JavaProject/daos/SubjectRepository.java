package ua.lviv.home.JavaProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.home.JavaProject.domain.Subject;

import java.util.Optional;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    Optional<Subject> findByName(String name);

@Modifying
@Query("update Subject s set s.name = :name, s.maxGrade=:maxGrade where s.id=:id")
void updateSubjectById(@Param("name") String name, @Param("maxGrade") int maxGrade,@Param("id") int id);
}
