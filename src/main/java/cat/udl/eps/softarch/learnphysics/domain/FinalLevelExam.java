package cat.udl.eps.softarch.learnphysics.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class FinalLevelExam extends Exam {

    @NotBlank
    private Float Mark;

    @NotBlank
    private String subject;

    @OneToMany
    private List<Level> level;
}
