package cat.udl.eps.softarch.learnphysics.domain;

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
    private Integer levelId;

    @NotBlank
    @Length(min = 1, max = 256)
    @Column(unique = true)
    private String name;

    @Length(min = 1, max = 256)
    private String description;


    //@OneToMany
    //private List<Topic> topics;

    @Override
    public Integer getId() {
        return levelId;
    }
}
