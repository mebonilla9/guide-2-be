package co.edu.umb.guide2be.model.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audit_student")
public class AuditStudent {

  @Id
  @SequenceGenerator(
    name = "audit_student_id_sequence",
    sequenceName = "audit_student_id_sequence"
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "audit_student_id_sequence"
  )
  private Integer id;
  @Column(length = 50)
  private String previousName;
  @Column(length = 50)
  private String newName;
  @Column(length = 50)
  private String previousProgram;
  @Column(length = 50)
  private String newProgram;
  private LocalDate modify;
  @Column(length = 20)
  private String process;
  @Column(length = 20)
  private String dbUser;
  @ManyToOne
  @JoinColumn(name = "id_student")
  private Student student;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    AuditStudent that = (AuditStudent) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
