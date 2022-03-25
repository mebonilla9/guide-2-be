package co.edu.umb.guide2be.application.controllers;

import co.edu.umb.guide2be.application.request.StudentRequest;
import co.edu.umb.guide2be.application.services.StudentService;
import co.edu.umb.guide2be.model.entities.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/students")
public record StudentController(StudentService studentService) {

  @PostMapping
  public ResponseEntity<Object> registerStudent(@RequestBody StudentRequest studentRequest){
    log.info("New student registration {}", studentRequest);
    studentService.registerStudent(studentRequest);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Student>> findAllStudents(){
    List<Student> students = studentService.findAllStudents();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }
}
