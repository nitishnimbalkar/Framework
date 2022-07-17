package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FunctionalTests", glue = { "stepDefinitions" }, monochrome = true
// ,stepNotifications = true
// ,publish = false
// ,tags = "@regression or @smoke"
		, plugin = { "pretty"
				, "html:target/cucumber-reports/cucumber-report.html"
				,"json:target/cucumber-reports/cucumber-report.json"
				,"junit:target/cucumber-reports/cucumber-report.xml"
				,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
				}
// ,plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report.json" }
)
public class TestRunner {
}
