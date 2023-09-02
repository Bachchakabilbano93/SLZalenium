package testrunnerautomasi;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",
glue={"AutomasiSteps"}, monochrome=true,
plugin= {"pretty","html:target/cucumber-reports.html","json:target/cucumber-reports/Cucumber.json",
"junit:target/cucumber-reports/cucumber.xml"})

public class TestRunneratmi extends AbstractTestNGCucumberTests {

}
