package PageClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class Movies extends BaseUi {
	WebDriver driver;
	public TopMenu topMenu;

	ArrayList<String> moviesLanguages;

	@FindBy(xpath = "//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[2]/a[1]/div/div[2]/div/img")
	WebElement comingSoon;

	public Movies(WebDriver driver) {
		this.driver = driver;
		topMenu = PageFactory.initElements(driver, TopMenu.class);

	}

	public void clickOnComingSoon() {
//		driver.findElement(By.xpath("//*[@id=\'super-container\']/div[2]/div[3]/div[2]/div[2]/div/div[2]/a[1]/div/div[2]/div/img")).click();
		comingSoon.click();
	}

	public TopMenu getTopMenu() {
		return topMenu;
	}

	public void fetchAllMoviesLanguages() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> languages = driver.findElements(By.xpath("//*[@class=\"style__StyledText-tgsgks-0 cAIFpf\"]"));
		for (int i = 0; i < languages.size(); i++) {
			System.out.println(languages.get(i).getText());
		}
	}

}
