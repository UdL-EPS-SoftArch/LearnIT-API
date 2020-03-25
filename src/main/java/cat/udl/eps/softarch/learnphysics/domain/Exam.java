package cat.udl.eps.softarch.learnphysics.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.mapping.List;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Exam")
@Data
@EqualsAndHashCode(callSuper = true)
public class Exam extends UriEntity<Integer> {
    @Id
    private Integer examId;

    @NotBlank
    private Integer nbOfQuestions;

    @Override
    public Integer getId() {
        return examId;
    }

    //@NotBlank
    //@OneToMany
    //private List<Question> Question;
}