package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelenieumUtility {

	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void selectByVisibleText(WebElement element, String value) {
		Select dropDown = new Select(element);
		if (dropDown.getOptions().parallelStream().anyMatch(x -> x.getText().equals(value)))
			dropDown.selectByVisibleText(value);
		else
			throw new RuntimeException("Value "+value+" is not available in dropdown for selection");
	}
}
