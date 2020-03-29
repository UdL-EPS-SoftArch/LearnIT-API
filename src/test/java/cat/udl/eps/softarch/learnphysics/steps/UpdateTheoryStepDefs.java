package cat.udl.eps.softarch.learnphysics.steps;



import cat.udl.eps.softarch.learnphysics.domain.Theory;
import cat.udl.eps.softarch.learnphysics.repository.TheoryRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UpdateTheoryStepDefs {
    @Autowired
    private TheoryRepository theoryRepository;
    @Autowired
    private StepDefs stepDefs;

    @When("I change the theory text that have name {string} to {string}")
    public void iChangeTheTheoryTextWithNameTo(String name, String newText) throws Exception {
        Theory theory=theoryRepository.findTheoriesByName(name);
        JSONObject team_json = new JSONObject();
        team_json.put("text",newText);
        stepDefs.result = stepDefs.mockMvc.perform(
                patch("/theories/{id}",theory == null ? 0: theory.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(team_json.toString())
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate())
        ).andDo(print());
    }

    @And("it has been changed theory text with name {string} and new text {string}")
    public void itHasBeenChangedTheoryTextWithNameAndNewText(String name, String newText) throws Exception {
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/theories/{id}",theoryRepository.findTheoriesByName(name).getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.text",is(newText))).andDo(print());
    }

    @And("And I cannot update theory with name {string}")
    public void andICannotUpdateTheoryWithName(String name) throws Exception {
        Theory theory=theoryRepository.findTheoriesByName(name);
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/theories/{id}",theory == null ? 0: theory.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Given("There no theory with name {string}")
    public void thereNoTheoryWithName(String name) {
        Assert.assertFalse(theoryRepository.existsTheoriesByName(name));
    }

    @When("I change the theory url that have name {string} to {string}")
    public void iChangeTheTheoryUrlWithNameTo(String name, String newUrl) throws Exception {
        Theory theory=theoryRepository.findTheoriesByName(name);
        JSONObject team_json = new JSONObject();
        team_json.put("url",newUrl);
        stepDefs.result = stepDefs.mockMvc.perform(
                patch("/theories/{id}",theory == null ? 0: theory.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(team_json.toString())
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate())
        ).andDo(print());
    }



    @When("I change the theory name that have name {string} to {string}")
    public void iChangeTheTheoryNameWithNameTo(String name, String newName) throws Exception {
        Theory theory=theoryRepository.findTheoriesByName(name);
        JSONObject team_json = new JSONObject();
        team_json.put("name",newName);
        stepDefs.result = stepDefs.mockMvc.perform(
                patch("/theories/{id}",theory == null ? 0: theory.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(team_json.toString())
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate())
        ).andDo(print());
    }

    @And("it has been changed theory name with name {string} and new name {string}")
    public void itHasBeenChangedTheoryNameWithNameAndNewName(String name, String newName) throws Exception {
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/theories/{id}",theoryRepository.findTheoriesByName(name).getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.url",is(newName))).andDo(print());
    }
}
