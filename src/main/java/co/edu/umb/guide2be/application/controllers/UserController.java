package co.edu.umb.guide2be.application.controllers;

import co.edu.umb.guide2be.application.request.LoginRequest;
import co.edu.umb.guide2be.application.request.UserRequest;
import co.edu.umb.guide2be.application.services.UserService;
import co.edu.umb.guide2be.model.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public record UserController(UserService userService) {

  @PostMapping
  public ResponseEntity<?> registerUser(@RequestBody UserRequest userRequest){
    log.info("New user registration {}", userRequest);
    userService.registerUser(userRequest);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<User>> findAllUsers(){
    List<User> users = userService.findAllUsers();
    return new ResponseEntity<>(users,HttpStatus.OK);
  }
}
