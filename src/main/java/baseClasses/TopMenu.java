package baseClasses;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu {

	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/header/div[1]/div/div/div/div[2]/div[2]/div[1]")
	WebElement signIn;
	
	@FindBy(xpath="//*[@id=\"super-container\"]/div[2]/header/div[2]/div/div/div/div[1]/div/a[4]")
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
	public void setLocation()
	{
		location.click();
		mumbai.click();
	}
	
	public void signInUsingGmail()
	{
		signIn.click();
		gmail.click();
		//handle new window
	}
	//Storing popular cities in arrayList to check if the input location is from popular cities
//	public void setPopular(String city)
//	{
//		popularCities=new ArrayList<>();
//		popularCities.add("Mumbai");
//		popularCities.add("NCR");
//		popularCities.add("Bengaluru");
//		popularCities.add("Hydrabad");
//		popularCities.add("Ahemadabad");
//		popularCities.add("Chandigarh");
//		popularCities.add("Chennai");
//		popularCities.add("Pune");
//		popularCities.add("Kolkata");
//		popularCities.add("Kochi");
//	}
}
