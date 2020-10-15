package PageClasses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class Movies extends BaseUi{
	WebDriver driver;
	ArrayList<String> moviesLanguages;
	
	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/div[3]/div[2]/div[3]/div/div[2]/a[1]/div/div[2]/div/img")
	WebElement comingSoon;
	
	public TopMenu topMenu;
	
	public Movies(WebDriver driver)
	{
		this.driver=driver;
		topMenu=PageFactory.initElements(driver, TopMenu.class);
		
	}
	public void fetchAllMoviesLanguages()
	{
		
	}
	
}
