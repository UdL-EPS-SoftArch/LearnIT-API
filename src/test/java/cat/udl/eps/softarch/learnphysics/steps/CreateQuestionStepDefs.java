package cat.udl.eps.softarch.learnphysics.steps;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Question;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import cat.udl.eps.softarch.learnphysics.domain.User;
import cat.udl.eps.softarch.learnphysics.repository.LevelRepository;
import cat.udl.eps.softarch.learnphysics.repository.QuestionRepository;
import cat.udl.eps.softarch.learnphysics.repository.TopicRepository;
import cat.udl.eps.softarch.learnphysics.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CreateQuestionStepDefs {

    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private StepDefs stepDefs;


    @And("level id {int} and topic id {int} exist")
    public void levelAndTopicExist(Integer levelId, Integer topicId) {
        if (!levelRepository.existsById(levelId) & !topicRepository.existsById(topicId)) {
            Level level = new Level();
            level.setLevelId(levelId);
            levelRepository.save(level);
            Topic topic = new Topic();
            topic.setTopicId(topicId);
            topicRepository.save(topic);
        }
    }

    @And("topic {string} is in level {string}")
    public void topicIsInLevel(String arg0, String arg1) {

    }

    @When("I write a new question with statement {string}, answer {string} and level {string} and topic {string}")
    public void iWriteANewQuestionWithStatementAnswerAndLevelAndTopic(String statement, String answer, Integer levelId, Integer topicId) {
        Question question = new Question();
        question.setStatement(statement);
        question.setAnswer(answer);
        question.setLevelId(levelId);
        question.setTopicId(topicId);
        questionRepository.save(question);
    }

    @And("It has been created a question with statement {string} and answer {string}")
    public void itHasBeenCreatedAQuestionWithStatement(String statement, String answer) throws Exception {
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/questions/{statement id}", questionRepository.findQuestionByStatement(statement).getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate()))
                .andDo(print())
                .andExpect(jsonPath("$.answer", is(answer)));
    }

    @And("It has not been created a question with statement {string}")
    public void itHasNotBeenCreatedAQuestionWithStatement(String arg0) {

    }

    @And("Level {string} doesn't exist and topic {string} exist")
    public void levelDoesnTExistAndTopicExist(String arg0, String arg1) {

    }

    @And("question with statement {string} doesn't exist")
    public void questionWithStatementDoesnTExist(String statement) {
        Assert.assertFalse("Question \""
                        +  statement + "\"shouldn't exist",
                questionRepository.existsQuestionByStatement(statement));
    }

    @When("I write a new question with statement {string}, answer {string}")
    public void iWriteANewQuestionWithStatementAnswer(String statement, String answer) throws Throwable {
        Question question = new Question();
        question.setStatement(statement);
        question.setAnswer(answer);

        stepDefs.result = stepDefs.mockMvc.perform(
                post("/questions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                stepDefs.mapper.writeValueAsString(question)
                        )
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate()))
                .andDo(print());
    }



    @And("question with statement {string} exists")
    public void questionWithStatementExists(String statement) {
        if (!questionRepository.existsQuestionByStatement(statement))
        {
            Question question = new Question();
            question.setStatement(statement);
            question.setAnswer("answer");
            question.setLevelId(0);
            question.setTopicId(0);
            questionRepository.save(question);
        }
    }
}
