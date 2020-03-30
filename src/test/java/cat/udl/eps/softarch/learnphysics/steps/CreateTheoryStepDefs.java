package cat.udl.eps.softarch.learnphysics.steps;

import cat.udl.eps.softarch.learnphysics.domain.Level;
import cat.udl.eps.softarch.learnphysics.domain.Theory;
import cat.udl.eps.softarch.learnphysics.domain.Topic;
import cat.udl.eps.softarch.learnphysics.repository.LevelRepository;
import cat.udl.eps.softarch.learnphysics.repository.TheoryRepository;
import cat.udl.eps.softarch.learnphysics.repository.TopicRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CreateTheoryStepDefs {

    @Autowired
    private TheoryRepository theoryRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private LevelRepository levelRepository;
    @Autowired
    private StepDefs stepDefs;
    private Topic topic;
    private Level level;

    @And("theory with name {string} doesn't exist")
    public void theoryWithNameDoesnTExist(String name) {
        Assert.assertFalse("Theory \""
                        +  name + "\"shouldn't exist",
                theoryRepository.existsTheoriesByName(name));
    }


    @When("I write a new theory with name {string}, url {string} and text {string}")
    public void iWriteANewTheoryWithNameUrlAndText(String name, String url, String text) throws Exception {
        Theory theory = new Theory();
        theory.setName(name);
        theory.setURL(url);
        theory.setText(text);
        theory.setTopic(topic);

        stepDefs.result = stepDefs.mockMvc.perform(
                post("/theories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                stepDefs.mapper.writeValueAsString(theory)
                        )
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate()))
                .andDo(print());
    }

    @Given("There is a topic for theory")
    public void thereIsATopicForTheory() {
        if (!topicRepository.existsTopicByName("topic"))
        {
            topic = new Topic();
            topic.setTopicId(13);
            topic.setName("topic");
            topic.setDescription("bla bla bla");
            topic.setLevel(level);
            topicRepository.save(topic);
        }
    }

    @And("Level")
    public void level() {
        if (!levelRepository.existsLevelsByName("level"))
        {
            System.out.println("NEW LEVEL");
            level = new Level();
            level.setLevelId(13);
            level.setName("level");
            level.setDescription("bla bla bla");
            levelRepository.save(level);
        }
    }




    @And("It has been created a theory with name {string}, url{string} and text{string}")
    public void itHasBeenCreatedATheoryWithNameUrlAndText(String name, String url, String text) throws Exception {
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/theories/{id}", theoryRepository.findTheoriesByName(name).getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .with(AuthenticationStepDefs.authenticate()))
                .andDo(print())
                .andExpect(jsonPath("$.url", is(url)))
                .andExpect(jsonPath("$.text", is(text)));
    }

    @And("theory with name {string} exists")
    public void theoryWithNameExists(String name) {
        if (!theoryRepository.existsTheoriesByName(name))
        {
            Theory theory = new Theory();
            theory.setName(name);
            theory.setURL("youtube.com");
            theory.setText("text");
            theory.setLevel(level);
            theory.setTopic(topic);
            theoryRepository.save(theory);
        }
    }


    @And("It has not been created a theory with name {string}")
    public void itHasNotBeenCreatedATheoryWithName(String name) throws Exception {
        Theory theory=theoryRepository.findTheoriesByName(name);
        stepDefs.result = stepDefs.mockMvc.perform(
                get("/theories/{id}",theory == null ? 0: theory.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @And("theory with name {string}  exist")
    public void theoryWithNameExist(String name) {
        if (!theoryRepository.existsTheoriesByName(name))
        {
            Theory theory = new Theory();
            theory.setName(name);
            theory.setURL("youtube.com");
            theory.setText("text");
            theory.setLevel(level);
            theory.setTopic(topic);
            theoryRepository.save(theory);
        }
    }
}
