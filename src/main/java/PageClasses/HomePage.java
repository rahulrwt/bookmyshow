package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class HomePage extends BaseUi {
	WebDriver driver;

	public TopMenu topMenu;

	@FindBy(id = "wzrk-cancel")
	WebElement cancel;

	@FindBy(xpath = "//*[@id='modal-root']/div/div/div/div[2]/ul/li[1]/div/div/img")
	WebElement mumbai;

	public HomePage(WebDriver driver) {
		this.driver = driver; 
	}

	public TopMenu declineAlert() {
		waits(3000);
		cancel.click();
		waits(2000);
		mumbai.click();
		return PageFactory.initElements(driver, TopMenu.class);

	}
}