package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	ConfigFileReader configReader;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configReader = FileReaderManager.getInstance().getConfigReader();
	}

	public void perform_Search(String search) {
		driver.navigate().to(configReader.getApplicationUrl()+"/?s=" + search + "&post_type=product");
	}

	public void navigateTo_HomePage() {
		driver.get(configReader.getApplicationUrl());
	}
}
