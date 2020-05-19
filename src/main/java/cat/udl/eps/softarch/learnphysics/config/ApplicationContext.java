package cat.udl.eps.softarch.learnphysics.config;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Question;
import cat.udl.eps.softarch.learnphysics.domain.Theory;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import cat.udl.eps.softarch.learnphysics.repository.LevelRepository;
import cat.udl.eps.softarch.learnphysics.repository.QuestionRepository;
import cat.udl.eps.softarch.learnphysics.repository.TopicRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ApplicationContext implements InitializingBean {

    List<Level> levels = new ArrayList<>();
    //List<Level> topics = new ArrayList<>();

    final LevelRepository levelRepository;

    final TopicRepository topicRepository;

    final QuestionRepository questionRepository;

    public ApplicationContext(LevelRepository levelRepository, TopicRepository topicRepository, QuestionRepository questionRepository) {

        this.levelRepository = levelRepository;
        this.topicRepository = topicRepository;
        this.questionRepository = questionRepository;
    }

    private List<Question> makeQuestions(Integer lvlNum, String name) {

        List<Question> questions = new ArrayList<>();
        Question question;

        for (int i = 1; i <= 3; i++) {

            String statement = "Q" + Integer.toString(i) + " " + name;
            System.out.println(statement);

            question = new Question(statement, "yes");
            //question.setLevelId(t.getLevel());
            //question = questionRepository.save(question);
            questions.add(question);
        }

        questionRepository.saveAll(questions);

        return questions;
    }

    private List<Topic> makeTopics(Integer lvlNum, List<String> difficulties) {

        List<Topic> topics = new ArrayList<>();
        Topic topic;
        List<Question> questions;

        List<Theory> theory = new ArrayList<>();

        String topic_name;

        topic_name = "Computer Science Theory" + lvlNum;
        questions = makeQuestions(lvlNum, topic_name);
        topic = new Topic(topic_name, "This topic is " + difficulties.get(lvlNum-1) + "level difficulty to Computer Science Theory", questions, theory);
        topics.add(topic);

        for (Question q: questions) {
            q.setTopic(topic);
            questionRepository.save(q);
        }

        topic_name = "IT " + lvlNum;
        questions = makeQuestions(lvlNum, topic_name);
        topic = new Topic(topic_name, "This topic is " + difficulties.get(lvlNum-1) + "level difficulty to IT", questions, theory);
        topics.add(topic);

        for (Question q: questions) {
            q.setTopic(topic);
            questionRepository.save(q);
        }

        topic_name = "Programming " + lvlNum;
        questions = makeQuestions(lvlNum, topic_name);
        topic = new Topic(topic_name, "This topic is " + difficulties.get(lvlNum-1) + "level difficulty to Programming", questions, theory);
        topics.add(topic);

        for (Question q: questions) {
            q.setTopic(topic);
            questionRepository.save(q);
        }

        topic_name = "Hardware " + lvlNum;
        questions = makeQuestions(lvlNum, topic_name);
        topic = new Topic(topic_name, "This topic is " + difficulties.get(lvlNum-1) + "level difficulty to Hardware", questions, theory);
        topics.add(topic);

        for (Question q: questions) {
            q.setTopic(topic);
            questionRepository.save(q);
        }

        topic_name = "Build API " + lvlNum;
        questions = makeQuestions(lvlNum, topic_name);
        topic = new Topic(topic_name, "This topic is " + difficulties.get(lvlNum-1) + "level difficulty to Build API", questions, theory);
        topics.add(topic);

        for (Question q: questions) {
            q.setTopic(topic);
            questionRepository.save(q);
        }

        topicRepository.saveAll(topics);

        return topics;
    }

    private void makeLevel(Integer lvlNum) {
        List<String> difficulties = Arrays.asList("Rookie", "Novice", "Advanced Novice", "Apprentice", "Advanced Apprentice", "Adept", "Advanced Adept","Expert", "Master", "Legendary");
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
