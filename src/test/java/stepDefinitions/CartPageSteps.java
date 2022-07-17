package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageObjects.CartPage;

public class CartPageSteps {
	TestContext testContext;
	private CartPage cartPage;

	public CartPageSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
	}

	@When("moves to checkout from mini cart")
	public void moves_to_checkout_from_mini_cart() {
		System.out.println("Moving selected item to Cart and then Moving to Checkout Page");
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();
	}

	@When("user selects {string} and {string} to Add to cart")
	public void user_selects_and_to_add_to_cart(String color, String size) {
		cartPage.selectColor(color);
		cartPage.selectSize(size);
		cartPage.clickOn_ContinueToCheckout();
	}

}
