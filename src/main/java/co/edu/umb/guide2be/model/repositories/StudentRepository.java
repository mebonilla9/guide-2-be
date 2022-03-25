package co.edu.umb.guide2be.model.repositories;

import co.edu.umb.guide2be.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}