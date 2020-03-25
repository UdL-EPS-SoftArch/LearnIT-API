package cat.udl.eps.softarch.learnphysics.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

public class Question {

    @Id
    @Column(name="question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer question_id;

    @NotBlank
    @Column(unique = true)
    private String statement;

    @NotBlank
    private String answer;

    @NotBlank
    private String topic;

    @NotBlank
    private Integer level;

    @JoinColumn(name = "Exam_prove", nullable = false, updatable = false)
    @ManyToOne
    private Exam exam;
}
