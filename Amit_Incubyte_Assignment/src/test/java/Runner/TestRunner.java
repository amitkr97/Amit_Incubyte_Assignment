package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/Signup.feature", // Path to your feature file
        glue = {"StepDefinitions"}, // Package where step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports",
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        		}
       // monochrome=true
        		
)
public class TestRunner {

}