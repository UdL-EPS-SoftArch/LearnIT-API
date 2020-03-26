package cat.udl.eps.softarch.learnphysics.domain;


import java.util.Collection;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User {

    @Column(unique=true)
    private long id;

    private String name_2;
    private String creation_date;


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_TEACHER");
    }


}
