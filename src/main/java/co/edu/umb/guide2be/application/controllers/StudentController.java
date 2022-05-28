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
  public ResponseEntity<?> findAllStudents(){
    List<Student> students = studentService.findAllStudents();
    return new ResponseEntity<>(students, HttpStatus.OK);
  }

  @GetMapping("{id}")
  public ResponseEntity<?> findStudent(@PathVariable("id") Integer id){
    Student student = studentService.findStudent(id);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<?> editStudent(@RequestBody StudentRequest request){
    studentService.editStudent(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id){
    studentService.deleteStudent(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }


}
