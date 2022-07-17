package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.SelenieumUtility;

public class CartPage {
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = ".cart-button")
	private WebElement btn_Cart;

	@FindBy(how = How.CSS, using = ".checkout-button.alt")
	private WebElement btn_ContinueToCheckout;
	
	@FindBy(xpath = "//label[text()='Color']/following::select")
	private WebElement selectColor;
	
	@FindBy(xpath = "//label[text()='Size']/following::select")
	private WebElement selectSize;
	
	public void clickOn_Cart() {
		btn_Cart.click();
	}
	
	public void selectColor(String color) {
		SelenieumUtility.selectByVisibleText(selectColor, color);
	}
	
	public void selectSize(String size) {
		SelenieumUtility.selectByVisibleText(selectSize, size);
	}

	public void clickOn_ContinueToCheckout() {
		btn_ContinueToCheckout.click();
	}
}
