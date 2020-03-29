package cat.udl.eps.softarch.learnphysics.steps;


import cat.udl.eps.softarch.learnphysics.domain.Question;

import cat.udl.eps.softarch.learnphysics.repository.QuestionRepository;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class DeleteQuestionStepDefs {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private StepDefs stepDefs;

    @When("I delete the question with statement {string}")
    public void iDeleteTheQuestionWithIdStatement(String statement) throws Exception {
        Question question=questionRepository.findQuestionByStatement(statement);
        stepDefs.result = stepDefs.mockMvc.perform(
                delete("/questions/{id}",question == null ? 0: question.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate()))
                         .andDo(print());

    }


    @And("It has been deleted the question with statement {string}")
    public void itHasBeenDeletedTheQuestionWithStatement(String statement) {
        Assert.assertFalse(questionRepository.existsQuestionByStatement(statement));
    }

    @Given("There is a created question with statement {string} and answer {string}")
    public void thereIsACreatedQuestionWithStatementAndAnswer(String statement, String answer) {
        if (!questionRepository.existsQuestionByStatement(statement)) {
            Question question = new Question();
            question.setStatement(statement);
            question.setAnswer(answer);
            questionRepository.save(question);
        }
    }

    @Given("There is no question with statement {string}")
    public void thereIsNoQuestionWithStatement(String statement) {
        Assert.assertFalse(questionRepository.existsQuestionByStatement(statement));
    }


    @And("And I cannot delete question with statement {string}")
    public void andICannotDeleteQuestionWithStatement(String statement) throws Exception {
        Question question=questionRepository.findQuestionByStatement(statement);
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/questions/{id}",question == null ? 0: question.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
