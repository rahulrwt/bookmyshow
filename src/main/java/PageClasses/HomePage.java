package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class HomePage extends BaseUi {
	WebDriver driver;
	
	public TopMenu topMenu;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		topMenu=PageFactory.initElements(driver, TopMenu.class);
	}
	
}