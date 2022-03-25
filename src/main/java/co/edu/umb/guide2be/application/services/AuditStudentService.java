package co.edu.umb.guide2be.application.services;

import co.edu.umb.guide2be.model.entities.AuditStudent;
import co.edu.umb.guide2be.model.repositories.AuditStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record AuditStudentService(AuditStudentRepository auditStudentRepository) {

  public List<AuditStudent> findAll(){
    return auditStudentRepository.findAll();
  }

}
