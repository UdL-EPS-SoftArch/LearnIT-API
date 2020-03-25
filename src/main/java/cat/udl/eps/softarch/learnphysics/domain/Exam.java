package cat.udl.eps.softarch.learnphysics.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Exam")
@Data
@EqualsAndHashCode(callSuper = true)
public class Exam extends UriEntity<Integer> {

    @Id
    @Column(name="Exam_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer examId;

    @NotBlank
    private Integer nbOfQuestions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exam")
    private List<Question> questions;

    @Override
    public Integer getId() {
        return examId;
    }

    //@NotBlank
    //@OneToMany
    //private List<Question> Question;
}