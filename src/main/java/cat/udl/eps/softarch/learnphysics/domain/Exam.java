package cat.udl.eps.softarch.learnphysics.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.validator.constraints.Length;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Exam extends UriEntity<Integer> {
    //public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Length(min = 1, max = 256)
    @Column(unique = true)
    private String name;

    private Integer nbOfQuestions;

    @OneToMany(mappedBy="exam")
    private List<ExamQuestion> exams_questions;

    @OneToMany(mappedBy = "exam")
    private List<StudentExam> exam_students;

}
