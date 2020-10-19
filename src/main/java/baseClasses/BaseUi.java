package baseClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageClasses.HomePage;

public class BaseUi {

	public WebDriver driver;

//	@FindBy(id="")
//	WebElement cancel;
//	
	@FindBy(xpath="//*[@id=\"modal-root\"]/div/div/div/div[2]/ul/li[1]/div/div")
	WebElement mumbai;
	
	public void invokeBrowser(String browserName) {

		try {

			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\91950\\eclipse-workspace\\bookmyshow\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Mozila")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("Opera")) {
				System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/drivers/operadriver");
				driver = new OperaDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {
				driver = new SafariDriver();
			}
		} catch (Exception e) {
			// reportFail(e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	
	public HomePage openWebsite(String URL)
	{
		driver.get(URL);
		return PageFactory.initElements(driver,HomePage.class);
	}
	
	

	
}
