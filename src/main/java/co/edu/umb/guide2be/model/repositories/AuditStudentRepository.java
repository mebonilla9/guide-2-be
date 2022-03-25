package co.edu.umb.guide2be.model.repositories;

import co.edu.umb.guide2be.model.entities.AuditStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditStudentRepository extends JpaRepository<AuditStudent, Integer> {
}