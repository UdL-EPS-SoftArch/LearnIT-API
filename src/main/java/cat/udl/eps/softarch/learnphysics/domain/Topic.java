package cat.udl.eps.softarch.learnphysics.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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

    //@NotBlank
    @ManyToOne
    private Level level;

    //@NotBlank
    //@OneToMany
    //private String questions;

    //@NotBlank
    //@OneToMany
    //private String theory;

    @Override
    public Integer getId() {
        return topicId;
    }
}
