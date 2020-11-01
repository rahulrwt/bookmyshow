package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageClasses.GoogleSignIn;
import pageClasses.Movies;
import pageClasses.Sports;

public class TopMenu extends BaseUi {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"super-container\"]/div[2]/div[2]/header/div[1]/div/div/div/div[2]/div[2]/div[1]")
	WebElement signIn;

	@FindBy(linkText = "Sports")
	WebElement sports;

	@FindBy(linkText = "Movies")
	WebElement movies;

	@FindBy(xpath = "//*[@id=\"super-container\"]/div[2]/header/div[1]/div/div/div/div[2]/div[1]/span")
	WebElement location;

	@FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div/div[1]/div/div/input")
	WebElement searchCity;

	@FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div/div[1]/div[2]/div/ul/li/span")
	WebElement error;

	@FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div/div[2]/ul/li[1]/div/div/img")
	WebElement mumbai;

	@FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/div")
	WebElement gmail;

	public TopMenu(WebDriver driver) {
		this.driver = driver;
	}

	public void setLocation() {
		location.click();
		mumbai.click();

	}

	public Sports goToSports() {
	
		waits(2000);
		sports.click();
		return PageFactory.initElements(driver, Sports.class);

	}

	public Movies goToMovies() {
		waits(2000);
		movies.click();
		return PageFactory.initElements(driver, Movies.class);
	}

	public GoogleSignIn signInUsingGmail() {
		gmail.click();
		return PageFactory.initElements(driver, GoogleSignIn.class);
		
	}
	public void signInClick() {
		signIn.click();
		waits(2000);
	}

}