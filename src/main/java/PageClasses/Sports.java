package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class Sports	extends BaseUi {
	
	WebDriver driver;
	public TopMenu topMenu;
	
	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[2]")
	WebElement weekend;
	
	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div/div[2]/div[4]/div/div[1]")
	WebElement price;
	
	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div/div[2]/div[4]/div/div[1]")
	WebElement free;
	
	public Sports(WebDriver driver)
	{
		this.driver=driver;
		topMenu=PageFactory.initElements(driver, TopMenu.class);
	}
	
	public void setDate()
	{
		weekend.click();
	}
	
	public void setPrice()
	{
		price.click();
		free.click();
	}
	
	public TopMenu getTopMenu()
	{
		return topMenu;
	}
	
	public void sportsWithLeastCharges()
	{
		
	}
}