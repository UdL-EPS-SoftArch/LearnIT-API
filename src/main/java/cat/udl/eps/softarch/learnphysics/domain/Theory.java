package cat.udl.eps.softarch.learnphysics.domain;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Data
public class Theory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(min = 1, max = 256)
    @NotBlank
    @Column(unique = true)
    private String name;

    private String contentLink;
    @Lob
    @Column(length = 100 * 1024)
    private String text;

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Topic topic;
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private Level level;

}
