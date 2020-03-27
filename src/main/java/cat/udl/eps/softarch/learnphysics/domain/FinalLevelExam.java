package cat.udl.eps.softarch.learnphysics.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "FinalLevelExam")
@Data
@EqualsAndHashCode(callSuper = true)
public class FinalLevelExam extends Exam{

    @Id
    @Column(name="FinalLevelExam_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer FinalLevelExamId;

    @NotBlank
    private Float Mark;

    @NotBlank
    private String subject;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "FinalLevelExam")
    private List<Level> level;

    @Override
    public Integer getId() {
        return FinalLevelExamId;
    }

}