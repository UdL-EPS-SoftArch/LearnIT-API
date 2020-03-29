package cat.udl.eps.softarch.learnphysics.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String statement;

    @NotBlank
    private String answer;

    @NotBlank
    private String topic;

    @NotBlank
    private Integer level;

    @ManyToOne
    private Exam exam;
}
