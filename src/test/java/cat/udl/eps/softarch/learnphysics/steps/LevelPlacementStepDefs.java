package cat.udl.eps.softarch.learnphysics.steps;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.User;
import cat.udl.eps.softarch.learnphysics.repository.LevelRepository;
import cat.udl.eps.softarch.learnphysics.repository.TopicRepository;
import cat.udl.eps.softarch.learnphysics.repository.UserRepository;
import io.cucumber.core.gherkin.vintage.internal.gherkin.ast.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class LevelPlacementStepDefs {

    @Autowired
    private StepDefs stepDefs;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    public static boolean isEvalTestSuccessfullyCompleted;
    public String newResourceUri;
    public User student = new User();

    public String getNewResourceUri(){
        return newResourceUri;
    }


    @Given("Student with username {string} has completed an evaluation test with score {string}")
    public void studentWithUsernameHasCompletedAnEvaluationTestWithScore(String username, String score) throws Throwable {
        Assert.assertTrue(userRepository.existsById(username));
       // Assert.assertEquals(true, userRepository.existsByScore(Integer.valueOf(score)));
    }

    @Then("Student with score {string} has been sorted into level {string} according to the table")
    public void studentWithScoreHasBeenSortedIntoLevelAccordingToTheTable(String score, String level, DataTable data) throws Throwable {
        Integer lvl = null;
        for (int i = 1; i < 10; i++) {
         /*   if (student.getScore() < data.getRows().get(i-1).getCells().get(0)) {
                lvl = i;
                break;
            }*/
        }
        if(lvl == null) lvl = 10;
        //Assert.assertEquals(student.getLevel(), lvl);
    }
}
