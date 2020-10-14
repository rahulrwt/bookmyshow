package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClasses.BaseUi;

public class Sports	extends BaseUi {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[2]")
	WebElement weekend;
	
	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div/div[1]/div/svg")
	WebElement price;
	
	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div[2]/div[1]/div[2]/div/div")
	WebElement free;
	
	public Sports(WebDriver driver)
	{
		this.driver=driver;
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
	
	public void sportsWithLeastCharges()
	{
		
	}
	
}
