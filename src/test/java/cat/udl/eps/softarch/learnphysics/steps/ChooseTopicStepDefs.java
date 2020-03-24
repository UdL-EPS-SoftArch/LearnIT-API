package cat.udl.eps.softarch.learnphysics.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.boot.logging.Slf4JLoggingSystem;

public class ChooseTopicStepDefs {
    @Given("I navigate to the page with available topics for a level as a student")
    public void iNavigateToThePageWithAvailableTopicsForALevelAsAStudent() {
        System.out.println("I navigate to the page with available topics for a level as a student.");
    }

    @And("I click on the topic that I want to study")
    public void iClickOnTheTopicThatIWantToStudy() {
        System.out.println("I click on the topic that I want to study");
    }

    @Then("I should see the page with theory and questions for the topic I chose")
    public void iShouldSeeThePageWithTheoryAndQuestionsForTheTopicIChose() {
        System.out.println("I should see the page with theory and questions for the topic I chose");
    }
}
