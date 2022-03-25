package co.edu.umb.guide2be.application.services;

import co.edu.umb.guide2be.application.request.StudentRequest;
import co.edu.umb.guide2be.model.entities.Student;
import co.edu.umb.guide2be.model.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record StudentService(StudentRepository studentRepository) {

  public void registerStudent(StudentRequest request){
    Student student = Student.builder()
      .name(request.name())
      .program(request.program())
      .build();
    studentRepository.save(student);
  }

  public List<Student> findAllStudents(){
    return studentRepository.findAll();
  }
}
