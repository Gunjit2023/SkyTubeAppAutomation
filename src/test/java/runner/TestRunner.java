package runner;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class) //Junit execution

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/report.html",
        "json:target/cucumber-reports/report.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, // reporting
        // purpose
        monochrome = true, // console output color
//		tags = "@registertest", // tags from feature file
        features = { "src/test/resources/features" }, // location of feature files - folder name
        glue = "stepDefinitions") // location of step definition files - package name


public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {

        return super.scenarios();
    }

}
