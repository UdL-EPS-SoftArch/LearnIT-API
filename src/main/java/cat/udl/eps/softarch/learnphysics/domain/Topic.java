package cat.udl.eps.softarch.learnphysics.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Topic extends UriEntity<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer topicId;

    @NotBlank
    private String name;

    @Length(min = 1, max = 256)
    private String description;

    @Override
    public Integer getId() {
        return topicId;
    }
}
