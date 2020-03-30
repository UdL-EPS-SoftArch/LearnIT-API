package cat.udl.eps.softarch.learnphysics.config;

import cat.udl.eps.softarch.learnphysics.domain.*;
import cat.udl.eps.softarch.learnphysics.repository.LevelRepository;
import cat.udl.eps.softarch.learnphysics.repository.TopicRepository;
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
  final LevelRepository levelRepository;
  final TopicRepository topicRepository;


  public AuthenticationConfig(BasicUserDetailsService basicUserDetailsService, UserRepository userRepository, LevelRepository levelRepository,TopicRepository topicRepository) {
    this.basicUserDetailsService = basicUserDetailsService;
    this.userRepository = userRepository;
    this.levelRepository=levelRepository;
    this.topicRepository=topicRepository;
  }

  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(basicUserDetailsService)
        .passwordEncoder(User.passwordEncoder);

      // Sample user
    Level level = null;

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

    /*
    if (!levelRepository.existsLevelsByName("levelname")) {
      level = new Level();
      level.setLevelId(11);
      level.setName("levelname");
      level.setDescription("bla bla bla");
      levelRepository.save(level);
    }
    if (!topicRepository.existsTopicByName("topicname")) {
      Topic topic = new Topic();
      topic.setTopicId(12);
      topic.setName("topicname");
      topic.setDescription("bla bla bla");
      topic.setLevel(level);
      topicRepository.save(topic);
    }*/

  }
}
