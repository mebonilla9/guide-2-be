package co.edu.umb.guide2be.application.services;

import co.edu.umb.guide2be.application.request.LoginRequest;
import co.edu.umb.guide2be.application.request.UserRequest;
import co.edu.umb.guide2be.model.entities.User;
import co.edu.umb.guide2be.model.repositories.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public record UserService(
  UserRepository userRepository) {

  public void registerUser(UserRequest request) {
    User user = User.builder()
      .username(request.username())
      //.password(passwordEncoder().encode(request.password()))
      .password(DigestUtils.sha3_384Hex(request.password()))
      .level(request.level())
      .build();
    userRepository.save(user);
  }

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  public void login(LoginRequest request) throws Exception {
    Optional<User> user = userRepository.findUserByUsernameAndPassword(
      request.username(),
      DigestUtils.sha3_384Hex(request.password())
    );
    if (user.isEmpty()){
      throw new Exception("Usuario no encontrado");
    }
  }
}
