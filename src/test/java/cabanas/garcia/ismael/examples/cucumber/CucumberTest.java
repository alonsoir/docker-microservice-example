package cabanas.garcia.ismael.examples.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by XI317311 on 03/02/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
)
public class CucumberTest {
}
