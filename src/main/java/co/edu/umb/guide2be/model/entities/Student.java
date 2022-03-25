package co.edu.umb.guide2be.model.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

  @Id
  @SequenceGenerator(
    name = "student_id_sequence",
    sequenceName = "student_id_sequence"
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_id_sequence"
  )
  private Integer id;
  @Column(length = 20)
  private String name;
  @Column(length = 50)
  private String program;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Student student = (Student) o;
    return id != null && Objects.equals(id, student.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
