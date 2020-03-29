package cat.udl.eps.softarch.learnphysics.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Level extends UriEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer levelId;

    @NotBlank
    @Length(min = 1, max = 256)
    @Column(unique = true)
    private String name;

    @Length(min = 1, max = 256)
    private String description;

    @OneToMany
    private List<Topic> topics;

    public Level() {
    }

    public Level(int levelId, String name, String description, List<Topic> topics) {
        this.levelId = levelId;
        this.name = name;
        this.description = description;
        this.topics = topics;
    }

    @Override
    public Integer getId() {
        return levelId;
    }
}
