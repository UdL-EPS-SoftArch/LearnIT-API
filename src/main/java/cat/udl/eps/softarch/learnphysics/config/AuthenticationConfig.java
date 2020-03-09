package cat.udl.eps.softarch.learnphysics.config;

import cat.udl.eps.softarch.learnphysics.domain.Student;
import cat.udl.eps.softarch.learnphysics.domain.Teacher;
import cat.udl.eps.softarch.learnphysics.domain.User;
import cat.udl.eps.softarch.learnphysics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;

@Configuration
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {

  @Value("${default-password}")
  String defaultPassword;

  final BasicUserDetailsService basicUserDetailsService;
  final UserRepository userRepository;

  public AuthenticationConfig(BasicUserDetailsService basicUserDetailsService, UserRepository userRepository) {
    this.basicUserDetailsService = basicUserDetailsService;
    this.userRepository = userRepository;
  }

  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(basicUserDetailsService)
        .passwordEncoder(User.passwordEncoder);

    // Sample user
    if (!userRepository.existsById("demo")) {
      User player = new User();
      player.setEmail("demo@sample.app");
      player.setUsername("demo");
      player.setPassword(defaultPassword);
      player.encodePassword();
      userRepository.save(player);
    }

      // Sample user
      if (!userRepository.existsById("teacher")) {
        User teacher = new Teacher();
        teacher.setEmail("teacher@sample.app");
        teacher.setUsername("teacher");
        teacher.setPassword("teacherpassword");
        teacher.encodePassword();
        userRepository.save(teacher);
    }

      if (!userRepository.existsById("student")) {
      User student = new Student();
      student.setEmail("student@sample.app");
      student.setUsername("student");
      student.setPassword("studentpassword");
      student.encodePassword();
      userRepository.save(student);
    }
  }
}
