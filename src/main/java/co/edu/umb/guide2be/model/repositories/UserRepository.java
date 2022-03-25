package co.edu.umb.guide2be.model.repositories;

import co.edu.umb.guide2be.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findUserByUsernameAndPassword(String username, String Password);

}