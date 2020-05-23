
package cat.udl.eps.softarch.learnphysics.domain;

import com.sun.istack.Nullable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ExamQuestion extends UriEntity<Integer> {
    //public class ExamQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

}
