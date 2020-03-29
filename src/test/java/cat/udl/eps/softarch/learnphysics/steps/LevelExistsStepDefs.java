package cat.udl.eps.softarch.learnphysics.steps;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.repository.LevelRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultMatcher;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


public class LevelExistsStepDefs {
    @Autowired
    private StepDefs stepDefs;

    @Given("The application has been started")
    public void theApplicationHasBeenStarted() {
    }

    @When("I retrieve the list of levels")
    public void iRetrieveTheListOfLevels() throws Exception {
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/levels")
                    .accept(MediaType.APPLICATION_JSON)
                    .with(AuthenticationStepDefs.authenticate()))
                .andDo(print());
    }

    @Then("The list has {int} levels")
    public void theListHasLevels(int numLevels) throws Exception {
        stepDefs.result.andExpect(jsonPath("$._embedded.levels", hasSize(numLevels)));
    }

    @Given("There is a level with name {int}")
    public void thereIsALevelWithName(int lvlName) throws Exception {
        stepDefs.result.andExpect(jsonPath("$._embedded.levels", hasItem(lvlName)));
    }

    @When("I try to access level {int}")
    public void iTryToAccessLevel(int lvlName) throws Exception {
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/levels/{lvlName}", lvlName)
                    .accept(MediaType.APPLICATION_JSON)
                    .with(AuthenticationStepDefs.authenticate()))
                .andDo(print());
    }
}
