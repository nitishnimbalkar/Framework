package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageObjects.ProductListingPage;

public class ProductPageSteps {
	TestContext testContext;
	private ProductListingPage productListingPage;

	public ProductPageSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductListingPage();
	}

	@When("choose to buy the first item")
	public void choose_to_buy_the_first_item() {
		System.out.println("Finding the Webelement and selecting the First Item");
		String productName = productListingPage.getProductName(0);
		testContext.getScenarioContext().setContext("product_name", productName);
		productListingPage.select_Product(0);
		productListingPage.selectColor("White");
		productListingPage.selectSize("Small");
		productListingPage.clickOn_AddToCart();
	}
}
