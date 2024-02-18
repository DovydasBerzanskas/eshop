package lt.codeacademy.eshop.jpa.repositories;

import lt.codeacademy.eshop.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value =
    "SELECT u FROM User u" +
    " JOIN FETCH u.authorities" +
    " WHERE u.email = :email")
    Optional<User> findUserByEmailWithAuthorities(String email);
}
