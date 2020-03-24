package cat.udl.eps.softarch.learnphysics.steps;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.repository.LevelRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class LevelPlacementStepDefs {

    private Integer resultOfEvalTest;
    private String student; //Student student
    private Level levelAfterEvalTest;
    //private EvaluationTest evaluationTest;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private StepDefs stepDefs;

    @Given("^There is an evaluation test result$")
    public void thereIsAnEvalTestResult() {
        student.setLevel(evaluationTest.getEvalTestResult());
    }

    @When("^The evaluation test result ranges from: $")
    public boolean checkResultForLevelOne() {

    }


        @When("^The evaluation test result ranges from <start> to <end>$")
    public boolean checkResultForLevelOne()  {
        if (evaluationTest.getResult() <= 25 && evaluationTest() >= 0)
            return true;
        return false;
    }

    @Then("^The student goes to level <lvl>$")
    public void goToFirstLevel() {
        student.setLevel(1);
    }



}
