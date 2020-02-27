package cat.udl.eps.softarch.learnphysics.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class DeleteQuestionStepDefs {
    @And("question with id {string} exists")
    public void questionWithIdExists(String arg0) {

    }

    @When("I delete the question with id {string}")
    public void iDeleteTheQuestionWithId(String arg0) {

    }

    @And("It has not been deleted the question with id {string}")
    public void itHasNotBeenDeletedTheQuestionWithId(String arg0) {


    }

    @And("It has been deleted the question with id {string}")
    public void itHasBeenDeletedTheQuestionWithId(String arg0) {

    }

    @And("question with id {string} doesn't exist")
    public void questionWithIdDoesnTExist(String arg0) {
    }
}
