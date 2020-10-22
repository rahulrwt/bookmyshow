package PageClasses;

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
		topMenu = PageFactory.initElements(driver, TopMenu.class);
	}

	public void declineAlert() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cancel.click();

	}

	public void setLocation() {
		mumbai.click();
	}

	public TopMenu getTopMenu() {
		return topMenu;
	}
}