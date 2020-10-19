package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class GoogleSignIn extends BaseUi{
	WebDriver driver;
	public TopMenu topMenu;
	@FindBy(xpath="//*[@type=\"email\"]")
	WebElement emailField;
	
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button")
	WebElement nextButton;
	
	@FindBy(xpath="//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[2]/div[2]/div")
	WebElement error;
	
	public GoogleSignIn(WebDriver driver)
	{
		this.driver=driver;
		topMenu=PageFactory.initElements(driver, TopMenu.class);
	}
	public void setEmail(String email)
	{
		emailField.sendKeys(email);
	}
	public void printError()
	{
		String errorText=error.getAttribute("innerHTML");
		System.out.println(errorText);
	}
	public TopMenu getTopMenu()
	{
		return topMenu;
	}
}