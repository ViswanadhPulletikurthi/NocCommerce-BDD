package TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions(
		    features = "src/test/resources/Features", // Path to feature files src\test\resources\Features\loginPage.feature
		    glue = "stepDefinations", // Package containing step definitions
		    		plugin = {
		    		        "pretty",
		    		        "json:target/cucumber/report.json",
		    		        "html:target/cucumber/report.html"
		    		    },
		    dryRun=false,
		    monochrome = true // Makes console output more readable
		)
		public class testRun extends AbstractTestNGCucumberTests {
		    // This class remains empty and serves as the test runner
		}
	


