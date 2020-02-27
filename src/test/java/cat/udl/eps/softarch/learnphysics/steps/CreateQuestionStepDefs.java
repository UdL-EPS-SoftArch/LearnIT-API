package cat.udl.eps.softarch.learnphysics.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateQuestionStepDefs {
    @And("level {string} and topic {string} exist")
    public void levelAndTopicExist(String arg0, String arg1) {
    }

    @And("topic {string} is in level {string}")
    public void topicIsInLevel(String arg0, String arg1) {

    }

    @When("I write a new question with statement {string}, answer {string} and level {string} and topic {string}")
    public void iWriteANewQuestionWithStatementAnswerAndLevelAndTopic(String arg0, String arg1, String arg2, String arg3) {
    }

    @And("It has been created a question with statement {string}")
    public void itHasBeenCreatedAQuestionWithStatement(String arg0) {
    }

    @And("It has not been created a question with statement {string}")
    public void itHasNotBeenCreatedAQuestionWithStatement(String arg0) {

    }

    @And("Level {string} doesn't exist and topic {string} exist")
    public void levelDoesnTExistAndTopicExist(String arg0, String arg1) {

    }

    @And("question with statement {string} doesn't exist")
    public void questionWithStatementDoesnTExist(String arg0) {
    }
}
