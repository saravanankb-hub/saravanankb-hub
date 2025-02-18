package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"utility", "stepDef"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "@Test")
public class TestRunner {

}
