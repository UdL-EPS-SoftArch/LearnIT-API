package cat.udl.eps.softarch.learnphysics.config;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Question;
import cat.udl.eps.softarch.learnphysics.domain.Theory;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import cat.udl.eps.softarch.learnphysics.repository.LevelRepository;
import cat.udl.eps.softarch.learnphysics.repository.TopicRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApplicationContext implements InitializingBean {

    List<Level> levels = new ArrayList<>();

    final LevelRepository levelRepository;

    final TopicRepository topicRepository;

    public ApplicationContext(LevelRepository levelRepository, TopicRepository topicRepository) {
        this.levelRepository = levelRepository;
        this.topicRepository = topicRepository;
    }

    private List<Topic> makeTopics(Integer lvlNum, List<String> difficulties) {
        List<Topic> topics = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        List<Theory> theory = new ArrayList<>();
        topics.add(new Topic("Computer Science Theory" + lvlNum, "This topic is " + difficulties.get(lvlNum-1)
                + "level difficulty to Computer Science Theory", questions, theory));
        topics.add(new Topic("IT " + lvlNum, "This topic is " + difficulties.get(lvlNum-1)
                + "level difficulty to IT", questions, theory));
        topics.add(new Topic("Programming " + lvlNum, "This topic is " + difficulties.get(lvlNum-1)
                + "level difficulty to Programming", questions, theory));
        topics.add(new Topic("Hardware " + lvlNum, "This topic is " + difficulties.get(lvlNum-1)
                + "level difficulty to Hardware", questions, theory));
        topics.add(new Topic("Build API " + lvlNum, "This topic is " + difficulties.get(lvlNum-1)
                + "level difficulty to Build API", questions, theory));
        return topics.stream().map(topicRepository::save).collect(Collectors.toList());
    }

    private void makeLevel(Integer lvlNum) {
        List<String> difficulties = Arrays.asList("Rookie", "Novice", "Advanced Novice", "Apprentice", "Advanced Apprentice",
                "Adept", "Advanced Adept","Expert", "Master", "Legendary");
        List<Topic> topics = makeTopics(lvlNum, difficulties);
        Level level = new Level(lvlNum, difficulties.get(lvlNum-1),
                "This level is of difficulty " + difficulties.get(lvlNum-1) + " and has topics: " + topics.get(0).getName() + ", " +
                        topics.get(1).getName() + ", " + topics.get(2).getName() + ", "
                        + topics.get(3).getName() +", and "+ topics.get(4).getName(), topics);
        levelRepository.save(level);
        levels.add(level);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(!levelRepository.existsById(1)) makeLevel(1);
        if(!levelRepository.existsById(2)) makeLevel(2);
        if(!levelRepository.existsById(3)) makeLevel(3);
        if(!levelRepository.existsById(4)) makeLevel(4);
        if(!levelRepository.existsById(5)) makeLevel(5);
        if(!levelRepository.existsById(6)) makeLevel(6);
        if(!levelRepository.existsById(7)) makeLevel(7);
        if(!levelRepository.existsById(8)) makeLevel(8);
        if(!levelRepository.existsById(9)) makeLevel(9);
        if(!levelRepository.existsById(10)) makeLevel(10);
    }
}
