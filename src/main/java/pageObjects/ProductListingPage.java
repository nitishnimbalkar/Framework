package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.SelenieumUtility;

public class ProductListingPage {
	WebDriver driver;

	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
	private WebElement btn_AddToCart;

	@FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
	private List<WebElement> prd_List;

	@FindBy(xpath = "//label[text()='Color']/following::select")
	private WebElement selectColor;

	@FindBy(xpath = "//label[text()='Size']/following::select")
	private WebElement selectSize;

	public void clickOn_AddToCart() {
		btn_AddToCart.click();
	}

	public void select_Product(int productNumber) {
		WebElement product = prd_List.get(productNumber);
		SelenieumUtility.scrollIntoView(driver, product);
		product.click();
	}

	public void selectColor(String color) {
		SelenieumUtility.selectByVisibleText(selectColor, color);
	}

	public void selectSize(String size) {
		SelenieumUtility.selectByVisibleText(selectSize, size);
	}

	public String getProductName(int productNumber) {
		return prd_List.get(productNumber).findElement(By.cssSelector("h3")).getText();
	}
}
