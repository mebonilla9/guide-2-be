package co.edu.umb.guide2be.application.controllers;

import co.edu.umb.guide2be.application.services.AuditStudentService;
import co.edu.umb.guide2be.model.entities.AuditStudent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/audits")
public record AuditStudentController(AuditStudentService auditStudentService) {

  @GetMapping
  public ResponseEntity<List<AuditStudent>> findAllAudits(){
    List<AuditStudent> audits = auditStudentService.findAll();
    return new ResponseEntity<>(audits, HttpStatus.OK);
  }
}
