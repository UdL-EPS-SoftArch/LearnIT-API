package cat.udl.eps.softarch.learnphysics;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty"}, features="src/test/resources", strict = true)
public class CucumberTest {

}
