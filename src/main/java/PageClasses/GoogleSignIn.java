package pageClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

		Set<String> windowsIds = driver.getWindowHandles();
		Iterator<String> iter = windowsIds.iterator();
		this.mainWindow = iter.next();
		String gmailWindow = iter.next();
		driver.switchTo().window(gmailWindow);
	}
// With valid email without entering captcha
	public void setEmailOne(String email) {
		
		waits(1000);
		emailField.sendKeys(email);
		nextButton.click();
		waits(1000);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
		waits(1000);
		driver.close();
		driver.switchTo().window(mainWindow);
		System.out.println("Test case 1 With valid email without entering captcha is passed");
		waits(2000);
		//driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();;
	}
	//Without email
	public void setEmailTwo(String email) {
		waits(1000);
		emailField.sendKeys(email);
		nextButton.click();
		waits(1000);
		driver.close();
		driver.switchTo().window(mainWindow);
		System.out.println("Test case 2 without entering mail is passed");
		waits(2000);
	}
	//Invalid email
	public void setEmailThree(String email) {
		waits(1000);
		emailField.sendKeys(email);
		nextButton.click();
		waits(1000);
		driver.close();
		driver.switchTo().window(mainWindow);
		System.out.println("Test case 3 with Invalid email is passed ");
		waits(2000);
	}
	//With valid email and  without password
	public void setEmailFour(String email) {
		
		waits(1000);
		emailField.sendKeys(email);
		nextButton.click();
		waits(20000);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
		waits(2000);
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();
		waits(1000);
		driver.close();
		driver.switchTo().window(mainWindow);
		System.out.println("Test case 4 With valid email and without password");
		//driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();;
	}
	//with valid mobile number
	public void setMobileOne(String number) {
		waits(2000);
		emailField.sendKeys(number);
		nextButton.click();
		waits(2000);
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();
		waits(1000);
		driver.close();
		driver.switchTo().window(mainWindow);
		System.out.println("Test case 5 With valid mobile number is passed");
	}
	//with invalid mobile number
	public void setMobileTwo(String number) {
		waits(2000);
		emailField.sendKeys(number);
		nextButton.click();
		waits(2000);
		driver.close();
		driver.switchTo().window(mainWindow);
		System.out.println("Test case 6 With invalid mobile number is passed");
	}

	public void printError() {
		waits(2000);
		String errorText = error.getText();
		System.out.println(errorText);
	}

//	public void closeSignIn() {
//		waits(2000);
//		driver.close();
//		driver.switchTo().window(mainWindow);
//		//driver.close();
//	}
}