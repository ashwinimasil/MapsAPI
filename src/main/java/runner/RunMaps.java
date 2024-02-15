package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/feature/maps.feature",glue="steps",publish=true,monochrome=true)
public class RunMaps extends AbstractTestNGCucumberTests {
	
	public void runGoogleMaps() {

	}
}
