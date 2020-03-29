package cat.udl.eps.softarch.learnphysics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Theory {

    @Id
    private Integer id;

    private String URL;

    private String text;

    @NotBlank
    private String topic;

    @NotBlank
    private Integer level;
}
