package cat.udl.eps.softarch.learnphysics.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class FinalLevelExam extends Exam{

    @NotBlank
    //@OneToMany
    private Integer level;

    @NotBlank
    private Float Mark;

    @NotBlank
    private String subject;

}