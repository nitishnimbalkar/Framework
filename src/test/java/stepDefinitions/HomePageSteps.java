package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class HomePageSteps {
	TestContext testContext;
	private HomePage homePage;

	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}

	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		homePage.navigateTo_HomePage();
	}

	@When("he search for {string}")
	public void he_search_for(String string) {
		System.out.println("Searching for " + string + " and navigating to it.");
		homePage.perform_Search(string);
	}
}
