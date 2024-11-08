package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags=("@Regression"),
        monochrome = true
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
