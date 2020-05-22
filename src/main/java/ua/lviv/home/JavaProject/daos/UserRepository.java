package ua.lviv.home.JavaProject.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.home.JavaProject.domain.User;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByVerifyEmailHash(String hash);

    @Modifying
    @Query("Update User u set u.isEmailVerified=TRUE where u.id = :userId")
    void confirmEmail(@Param("userId") int userId);

    @Modifying(flushAutomatically = true)
    @Query("Update User u set u.firstName=:firstName, u.lastName=:lastName ,u.email=:email, " +
            "u.dateOfBirth=:dateOfBirth, u.phoneNumber=:phoneNumber, u.address=:address, u.username=:username, " +
            " u.gender=:gender where u.id =:userId")
    void updateUser(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email,
                    @Param("dateOfBirth") String dateOfBirth,
                    @Param("phoneNumber") Long phoneNumber, @Param("address") String address,
                    @Param("username") String username, @Param("gender") String gender, @Param("userId") int userId);

    @Modifying
    @Query("Update User u set u.image=:image where u.id = :userId")
    void updateImageByUserId(@Param("image") String image, @Param("userId") int userId);
}