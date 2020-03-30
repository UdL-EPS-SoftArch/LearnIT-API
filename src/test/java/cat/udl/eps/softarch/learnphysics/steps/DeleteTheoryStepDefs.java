package cat.udl.eps.softarch.learnphysics.steps;



import cat.udl.eps.softarch.learnphysics.domain.Theory;

import cat.udl.eps.softarch.learnphysics.repository.TheoryRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class DeleteTheoryStepDefs {
    @Autowired
    private TheoryRepository theoryRepository;
    @Autowired
    private StepDefs stepDefs;
    @Given("There is a created theory with name {string}")
    public void thereIsACreatedTheoryWithName(String name) {
        if (!theoryRepository.existsTheoriesByName(name)) {
            Theory theory = new Theory();
            theory.setName(name);
            theoryRepository.save(theory);
        }

    }

    @When("I delete the theory with name {string}")
    public void iDeleteTheTheoryWithName(String name) throws Exception {
        Theory theory=theoryRepository.findTheoriesByName(name);
        stepDefs.result = stepDefs.mockMvc.perform(
                delete("/theories/{id}",theory == null ? 0: theory.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate()))
                .andDo(print());
    }

    @And("It has been deleted the theory with name {string}")
    public void itHasBeenDeletedTheTheoryWithName(String name) {
        Assert.assertTrue(theoryRepository.existsTheoriesByName(name));
    }

    @Given("There is no theory with name {string}")
    public void thereIsNoTheoryWithName(String name) {
        Assert.assertFalse(theoryRepository.existsTheoriesByName(name));
    }

    @And("It has not been deleted the theory with name {string}")
    public void itHasNotBeenDeletedTheTheoryWithName(String name) throws Exception {
        Theory theory=theoryRepository.findTheoriesByName(name);
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/theories/{id}",theory == null ? 0: theory.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @And("And I cannot delete theory with name {string}")
    public void andICannotDeleteTheoryWithName(String name) throws Exception {
        Theory theory=theoryRepository.findTheoriesByName(name);
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/theories/{id}",theory == null ? 0: theory.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
