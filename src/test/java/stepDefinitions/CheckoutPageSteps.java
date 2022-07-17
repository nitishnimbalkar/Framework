package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {
	TestContext testContext;
	private CheckoutPage checkoutPage;

	public CheckoutPageSteps(TestContext context) {
		testContext = context;
		checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
	}

	@When("enter personal details on checkout page")
	public void enter_personal_details_on_checkout_page() {
		System.out.println("Entering personal details on checkout page");
		checkoutPage.fill_PersonalDetails();
	}

	@When("enter {string} personal details on checkout page")
	public void enter_personal_details_on_checkout_page(String customer) {
		System.out.println("Entering " + customer + " personal details on checkout page");
		Customer customerByName = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customer);
		checkoutPage.fill_PersonalDetails(customerByName);
	}

	@When("select same delivery address")
	public void select_same_delivery_address() {
		System.out.println("Selecting delevery address checkbox");
		checkoutPage.check_ShipToDifferentAddress(false);
	}

	@When("select payment method as {string} payment")
	public void select_payment_method_as_payment(String string) {
		System.out.println("Selecting payment method as " + string + " payment");
		checkoutPage.select_PaymentMethod(string);
	}

	@When("place the order")
	public void place_the_order() {
		System.out.println("Clicking on Pace button to submit order");
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
	}
}
