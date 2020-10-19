package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageClasses.Movies;
import PageClasses.Sports;

public class TopMenu extends BaseUi {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/header/div[1]/div/div/div/div[2]/div[2]/div[1]")
	WebElement signIn;
	
//	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/header/div[2]/div/div/div/div[1]/div/a[4]")
	WebElement sports;						
	

	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/header/div[2]/div/div/div/div[1]/div/a[1]")
	WebElement movies;
	
	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/header/div[1]/div/div/div/div[2]/div[1]/span")
	WebElement location;
	
	@FindBy(xpath="//*[@id=\"modal-root\"]/div/div/div/div[1]/div/div/input")
	WebElement searchCity;
	
	@FindBy(xpath="//*[@id=\"modal-root\"]/div/div/div/div[1]/div[2]/div/ul/li/span")
	WebElement error;
	
	@FindBy(xpath="//*[@id=\"modal-root\"]/div/div/div/div[2]/ul/li[1]/div/div/img")
	WebElement mumbai;
	
	@FindBy(xpath="//*[@id=\"modal-root\"]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div")
	WebElement gmail;
//	ArrayList<String> popularCities;
	public TopMenu(WebDriver driver)
	{
		this.driver=driver;
	}
	public void setLocation()
	{
		location.click();
		mumbai.click();
	
	}
	
	public Sports goToSports()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/header/div[2]/div/div/div/div[1]/div/a[4]")).click();
		return PageFactory.initElements(driver, Sports.class);
		
	}
	
	public Movies gotToMovies()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/header/div[2]/div/div/div/div[1]/div/a[4]")).click();
		return PageFactory.initElements(driver, Movies.class);
	}
public void signInUsingGmail()
	{
		signIn.click();
		gmail.click();

		//handle new window
	}

}
