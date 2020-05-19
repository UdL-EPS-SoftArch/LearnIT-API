
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
    @Nullable
    private Integer id;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

}
