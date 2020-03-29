package cat.udl.eps.softarch.learnphysics.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Topic extends UriEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer topicId;

    @NotBlank
    @Column(unique = true)
    private String name;

    @Length(min = 1, max = 256)
    private String description;

    @ManyToOne
    private Level level;

    @OneToMany
    private List<Question> questions;

    @OneToMany
    private List<Theory> theory;


    public Topic() {
    }

    public Topic(int topicId, String name, String description, List<Question> questions, List<Theory> theory) {
        this.topicId = topicId;
        this.name = name;
        this.description = description;
        this.questions = questions;
        this.theory = theory;
    }

    @Override
    public Integer getId() {
        return topicId;
    }
}
