package baseClasses;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageClasses.HomePage;

public class BaseUi {

	public WebDriver driver=null;
	public WebDriverWait wait = null;
	public Properties prop;
	public DesiredCapabilities cap = null;
//	public void invokeBrowser(String browserName) {
//
//		try {
//
//			if (browserName.equalsIgnoreCase("Chrome")) {
//				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
//				driver = new ChromeDriver();
//				
//			} else if (browserName.equalsIgnoreCase("Mozila")) {
//				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
//				driver = new FirefoxDriver();
//				
//			} else if (browserName.equalsIgnoreCase("Opera")) {
//				System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "\\drivers\\operadriver.exe");
//				driver = new OperaDriver();
//				
//			} else if (browserName.equalsIgnoreCase("IE")) {
//				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
//				driver = new InternetExplorerDriver();
//			} else {
//				driver = new SafariDriver();
//			}
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			
//			if (prop == null) {
//				prop = new Properties();
//				try {
//					FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\ObjectRepository\\projectConfigHackathon.properties");
//					prop.load(file);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//
//			}
//
//		} catch (Exception e) {
//			// reportFail(e.getMessage());
//			System.out.println(e.getMessage());
//		}
//	}

	public void invokeBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome"))
			{
				cap = DesiredCapabilities.chrome();
			} 
			else if (browserName.equalsIgnoreCase("edge")) 
			{
				cap = DesiredCapabilities.edge();
			} 
			else {
				cap = DesiredCapabilities.firefox();
			}
//			reportPass("Browser invoked is : " + browserName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
//			reportFail(e.getMessage());
		}
		try {
			
			driver = new RemoteWebDriver(new URL("http://192.168.1.28:4444/wd/hub"), cap);
		} 
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
	}

	public HomePage openWebsite(String URL) {
		driver.get("https://in.bookmyshow.com/");
		return PageFactory.initElements(driver, HomePage.class);
	}

	public void waits(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
