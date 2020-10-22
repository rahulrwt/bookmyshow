package PageClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class GoogleSignIn extends BaseUi {
	WebDriver driver;
	
	public TopMenu topMenu;
	String mainWindow;

	@FindBy(xpath = "//*[@id=\"identifierId\"]")
	WebElement emailField;

	@FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button")
	WebElement nextButton;

	@FindBy(xpath = "//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
	WebElement error;

	public GoogleSignIn(WebDriver driver) {
		this.driver = driver;
		topMenu = PageFactory.initElements(driver, TopMenu.class);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Set<String> windowsIds = driver.getWindowHandles();
		Iterator<String> iter = windowsIds.iterator();
		this.mainWindow = iter.next();
		String gmailWindow = iter.next();
		driver.switchTo().window(gmailWindow);
	}

	public void setEmail(String email) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		emailField.sendKeys(email);
		nextButton.click();
	}

	public void printError() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String errorText = error.getText();
		System.out.println(errorText);
	}

	public void closeSignIn() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().window(mainWindow);
		driver.close();
	}
}