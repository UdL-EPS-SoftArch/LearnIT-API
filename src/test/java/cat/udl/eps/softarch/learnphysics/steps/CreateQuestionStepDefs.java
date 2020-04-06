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
import io.cucumber.java.ht.Le;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CreateQuestionStepDefs {

    private   Level level;
    private   Topic topic;

    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private StepDefs stepDefs;


    @Given("There is a level with a topic")
    @Transactional
    public void thereIsALevel() {
        level = levelRepository.findLevelByName("Rookie");
        topic = topicRepository.findByLevel(level).get(0);
    }





    @When("I write a new question with statement {string} and answer {string}")
    public void iWriteANewQuestionWithStatementAnswerAndLevelAndTopic(String statement, String answer) throws Exception {
        Question question = new Question();
        question.setStatement(statement);
        question.setAnswer(answer);
        question.setLevelId(level);
        question.setTopicId(topic);
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

    @And("It has been created a question with statement {string} and answer {string}")
    public void itHasBeenCreatedAQuestionWithStatement(String statement, String answer) throws Exception {
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/questions/{id}", questionRepository.findQuestionByStatement(statement).getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate()))
                .andDo(print())
                .andExpect(jsonPath("$.answer", is(answer)));

    }

    @And("It has not been created a question with statement {string}")
    public void itHasNotBeenCreatedAQuestionWithStatement(String statement) throws Exception {


        Question question=questionRepository.findQuestionByStatement(statement);
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/questions/{id}",question == null ? 0: question.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @And("question with statement {string} doesn't exist")
    public void questionWithStatementDoesnTExist(String statement) {
        Assert.assertFalse("Question \""
                        +  statement + "\"shouldn't exist",
                questionRepository.existsQuestionByStatement(statement));
    }





    @And("question with statement {string} exists")
    public void questionWithStatementExists(String statement) {
        if (!questionRepository.existsQuestionByStatement(statement))
        {
            Question question = new Question();
            question.setStatement(statement);
            question.setAnswer("answer");
            question.setLevelId(level);
            question.setTopicId(topic);
            questionRepository.save(question);
        }
    }





}
