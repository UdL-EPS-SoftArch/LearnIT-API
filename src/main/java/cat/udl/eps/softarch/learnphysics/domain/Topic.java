package cat.udl.eps.softarch.learnphysics.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Topic extends UriEntity<Integer>{

    @Id
    private Integer topicId;

    @NotBlank
    private String name;

    @Length(min = 1, max = 256)
    private String description;

    @NotBlank
    @OneToMany
    private List<Question> questions;

    @NotBlank
    @OneToMany
    private List<Theory> theory;

    public Topic(int topicId, String name, String description, List<Question> questions, List<Theory> theory) {
        super();
    }

    @Override
    public Integer getId() {
        return topicId;
    }
}
