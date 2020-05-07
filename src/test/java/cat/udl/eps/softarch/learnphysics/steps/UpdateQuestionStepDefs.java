package cat.udl.eps.softarch.learnphysics.steps;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Question;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import cat.udl.eps.softarch.learnphysics.repository.LevelRepository;
import cat.udl.eps.softarch.learnphysics.repository.QuestionRepository;
import cat.udl.eps.softarch.learnphysics.repository.TopicRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UpdateQuestionStepDefs {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private StepDefs stepDefs;
    

    @When("I change the question answer that have statement {string} to {string}")
    public void iChangeTheQuestionWithStatementTo(String statement, String answer) throws Exception {
        Question question=questionRepository.findQuestionByStatement(statement);
        JSONObject team_json = new JSONObject();
        team_json.put("answer",answer);
        stepDefs.result = stepDefs.mockMvc.perform(
                patch("/questions/{id}",question == null ? 0: question.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(team_json.toString())
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate())
        ).andDo(print());
    }

    @And("It has been changed game of question with statement {string} to {string}")
    public void itHasBeenChangedGameOfTeamTo(String statement, String answer) throws Exception {
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/questions/{statement}",statement)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.game",is(answer))).andDo(print());
    }



    @Given("There is no question with statement {string} and answer {string}")
    public void thereNoQuestionWithStatementAndAnswer(String statement, String answer) {
      Assert.assertFalse(questionRepository.existsQuestionByStatement(statement));

    }



    @Given("There is a existed question with statement {string} and answer {string}")
    public void thereIsAExistedQuestionWithStatementAndAnswer(String statement, String answer) {
        if (!questionRepository.existsQuestionByStatement(statement)) {
            Question question = new Question();
            question.setStatement(statement);
            question.setAnswer(answer);
            questionRepository.save(question);
        }
    }

    @When("I change the question statement that have statement {string} to {string}")
    public void iChangeTheQuestionStatementWithStatementTo(String statement, String newStatement) throws Exception {
        Question question=questionRepository.findQuestionByStatement(statement);
        JSONObject team_json = new JSONObject();
        team_json.put("statement",newStatement);
        stepDefs.result = stepDefs.mockMvc.perform(
                patch("/questions/{id}",question == null ? 0: question.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(team_json.toString())
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate())
        ).andDo(print());
    }

    @And("And I cannot update question with statement {string}")
    public void andICannotUpdateQuestionWithStatement(String statement) throws Exception {
        Question question=questionRepository.findQuestionByStatement(statement);
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/questions/{id}",question == null ? 0: question.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @And("it has been changed question answer with statement {string} and new answer {string}")
    public void itHasBeenChangedQuestionAnswerWithStatementAndNewAnswer(String statement, String newAnswer) throws Exception {
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/questions/{id}",questionRepository.findQuestionByStatement(statement).getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.answer",is(newAnswer))).andDo(print());
    }


}
