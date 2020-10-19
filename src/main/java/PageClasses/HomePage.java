package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class HomePage extends BaseUi {
	WebDriver driver;
	
	public TopMenu topMenu;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		topMenu=PageFactory.initElements(driver, TopMenu.class);
	}
	public void declineAlert()
	{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("wzrk-cancel")).click();
			
	}
		public void setLocation()
		{
			driver.findElement(By.xpath("//*[@id='modal-root']/div/div/div/div[2]/ul/li[1]/div/div/img")).click();
		}
		public TopMenu getTopMenu()
		{
			return topMenu;
		}
}