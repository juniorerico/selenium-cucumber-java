package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty", 
		features = "src/test/resources/features", 
		glue = "selenium_easy/step_definitions",
		tags = {"@selenium-easy"}
)
public class TestRunner {

}
