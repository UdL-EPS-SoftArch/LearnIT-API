
package cat.udl.eps.softarch.learnphysics.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentExam extends UriEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_username")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @Column
    private boolean pendent;

    @Column
    private float mark;
}
