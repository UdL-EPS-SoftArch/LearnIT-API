package cat.udl.eps.softarch.learnphysics.domain;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class Exam {
    @Id
    private Integer examId;

    @NotBlank
    private Integer nbOfQuestions;

    //@NotBlank
    //@OneToMany
    //private List<Question> Question;
}