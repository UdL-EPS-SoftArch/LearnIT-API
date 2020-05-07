package cat.udl.eps.softarch.learnphysics.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class TopicsExistStepDef {
    @Autowired
    private StepDefs stepDefs;

    @When("I retrieve the list of topics for level {int}")
    public void iRetrieveTheListOfTopicsForLevel(int numLevel) throws Exception {
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/levels/{numlevel}/topics", numLevel)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print());
    }

    @Then("The level has {int} topics")
    public void theLevelHasTopics(int numTopics) throws Exception {
        stepDefs.result.andExpect(jsonPath("$._embedded.topics", hasSize(numTopics)));
    }

    @Given("There is level {int}")
    public void thereIsLevel(int numLevel) throws Exception {
        iRetrieveTheListOfTopicsForLevel(numLevel);
        stepDefs.result.andExpect(jsonPath("$._embedded.levels", hasItem(numLevel)));
    }

    @Then("It contains topic with name {string}")
    public void itContainsTopicWithName(String topicName) throws Exception {
        stepDefs.result.andExpect(jsonPath("$._embedded.topics", hasItem(topicName)));
    }
}
