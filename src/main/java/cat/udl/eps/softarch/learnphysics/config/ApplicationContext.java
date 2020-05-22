package cat.udl.eps.softarch.learnphysics.config;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Question;
import cat.udl.eps.softarch.learnphysics.domain.Theory;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import cat.udl.eps.softarch.learnphysics.repository.LevelRepository;
import cat.udl.eps.softarch.learnphysics.repository.TopicRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
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

        topicRepository.saveAll(topics);
        return topics;
    }

    private void makeLevel(Integer lvlNum) {
        List<String> difficulties = Arrays.asList("Rookie", "Novice", "Advanced Novice", "Apprentice", "Advanced Apprentice",
                "Adept", "Advanced Adept","Expert", "Master", "Legendary");
        List<Topic> topics = makeTopics(lvlNum, difficulties);
        Level level = new Level(lvlNum, difficulties.get(lvlNum-1),
                "This level is of difficulty " + difficulties.get(lvlNum-1) + " and has topics: " + topics.get(0).getName() + ", " +
                        topics.get(1).getName() + ", " + topics.get(2).getName() + ", "
                        + topics.get(3).getName() +", and "+ topics.get(4).getName());
        level = levelRepository.save(level);
        for (Topic t: topics) {
            t.setLevel(level);
            topicRepository.save(t);
        }
        levels.add(level);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(levelRepository.count() == 0) {
            for (int i = 1; i <= 10; i++) {
                makeLevel(i);
            }
        }
    }
}