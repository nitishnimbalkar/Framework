package stepDefinitions;

import org.junit.Assert;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import pageObjects.ConfirmationPage;

public class ConfirmationPageSteps {
	TestContext testContext;
	private ConfirmationPage confirmationPage;

	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}

	@Then("^verify the order details$")
	public void verify_the_order_details() {
		String productName = testContext.getScenarioContext().getContext("product_name");
		Assert.assertTrue(confirmationPage.getProductNames().parallelStream().anyMatch(x -> x.equals(productName)));
	}
}
