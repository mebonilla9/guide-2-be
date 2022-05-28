package co.edu.umb.guide2be.application.services;

import co.edu.umb.guide2be.application.request.StudentRequest;
import co.edu.umb.guide2be.model.entities.Student;
import co.edu.umb.guide2be.model.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record StudentService(StudentRepository studentRepository) {

  public void registerStudent(StudentRequest request){
    Student student = Student.builder()
      .firstName(request.firstName())
      .lastName(request.lastName())
      .program(request.program())
      .enable(Boolean.TRUE)
      .build();
    studentRepository.save(student);
  }

  public void editStudent(StudentRequest request){
    Student student = Student.builder()
      .id(request.id())
      .firstName(request.firstName())
      .lastName(request.lastName())
      .program(request.program())
      .enable(request.enable())
      .build();
    studentRepository.save(student);
  }

  public Student findStudent(Integer id){
    return studentRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Student not found"));
  }

  public List<Student> findAllStudents(){
    return studentRepository.findAll()
      .stream()
      .filter(Student::getEnable)
      .collect(Collectors.toList());
  }

  public void deleteStudent(Integer id){
    Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    student.setEnable(Boolean.FALSE);
    studentRepository.save(student);
  }
}
