package ua.lviv.home.JavaProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.home.JavaProject.domain.Application;
import ua.lviv.home.JavaProject.domain.User;

import java.util.List;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

    List<Application> findByUser(User user);
}