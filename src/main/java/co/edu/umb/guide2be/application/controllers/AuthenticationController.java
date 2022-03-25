package co.edu.umb.guide2be.application.controllers;

import co.edu.umb.guide2be.application.request.LoginRequest;
import co.edu.umb.guide2be.application.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/login")
public record AuthenticationController(UserService userService) {

  @PostMapping
  public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
    userService.login(loginRequest);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
