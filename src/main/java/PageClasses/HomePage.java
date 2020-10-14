package PageClasses;

import org.openqa.selenium.WebDriver;

import baseClasses.BaseUi;

public class HomePage extends BaseUi {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
}
