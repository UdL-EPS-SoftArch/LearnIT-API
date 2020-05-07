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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer levelId;

    @NotBlank
    @Length(min = 1, max = 256)
    @Column(unique = true)
    private String name;

    @Length(min = 1, max = 256)
    private String description;

    @OneToMany(mappedBy = "level")
    private List<Topic> topics;

    public Level() {
    }

    public Level(int levelId, String name, String description) {
        this.levelId = levelId;
        this.name = name;
        this.description = description;
    }

    @Override
    public Integer getId() {
        return levelId;
    }
}
