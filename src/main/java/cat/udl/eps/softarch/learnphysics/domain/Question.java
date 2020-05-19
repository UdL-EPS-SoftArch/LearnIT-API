package cat.udl.eps.softarch.learnphysics.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Question extends UriEntity<Integer> {
    //public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String statement;

    @NotBlank
    private String answer;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Topic topic;

    //@ManyToOne
    //@JsonIdentityReference(alwaysAsId = true)
    //private Level levelId;

    @OneToMany(mappedBy="question")
    private List<ExamQuestion> exams_questions;


    public Question() {
    }

    public Question(String statement, String answer) {
        this.statement = statement;
        this.answer = answer;
    }

}
