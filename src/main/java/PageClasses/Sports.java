package pageClasses;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class Sports extends BaseUi {

	WebDriver driver;
	public TopMenu topMenu;

	@FindBy(xpath = "//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[2]/div/div[2]")
	WebElement weekend;

	@FindBy(xpath = "//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div/div[2]/div[4]/div/div[1]")
	WebElement price;

	@FindBy(xpath = "//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div/div[2]/div[4]/div[2]/div[1]/div[2]/div/div")
	WebElement free;

	public Sports(WebDriver driver) {
		this.driver = driver;
		topMenu = PageFactory.initElements(driver, TopMenu.class);
	}

	public void filter() {
		waits(2000);
		weekend.click();
		waits(1000);
		price.click();
		waits(1000);
		free.click();

		}
	
	public TopMenu sportsWithLeastCharges() {
		ArrayList<String> data = new ArrayList<String>();

	waits(3000);

		// storing all sports free of charge
		List<WebElement> sportsElements = driver.findElements(By.xpath("//*[@class='style__StyledText-tgsgks-0 gSrwRF' and contains(text(),'FREE')]/../preceding-sibling::div[3]"));

		for (int i = 0; i < sportsElements.size(); i++) {
			data.add(sportsElements.get(i).getText());
			System.out.println(data.get(i));
		}
		// create excelSheet
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet samplesheet = workbook.createSheet("SampleSheet");
				
	    //create data
				Map<String, Object[]> dataSet = new TreeMap<String, Object[]>();
				dataSet.put("0", new Object[] { "ID", "Sports Name" });
				
				for(int i = 0; i<sportsElements.size(); i++) {
				dataSet.put(""+i+1, new Object[] { i+1 , sportsElements.get(i).getText()});
				}
		//Iterate over the data
				Set<String> set = dataSet.keySet();
				int rownum = 0;

				for (String key : set) {

					Row row = samplesheet.createRow(rownum++);

					Object[] data1 = dataSet.get(key);

					int cellNum = 0;

					for (Object value : data1) {

						Cell cell = row.createCell(cellNum++);

						if (value instanceof String)
							cell.setCellValue((String) value);
						else if (value instanceof Integer)
							cell.setCellValue((Integer) value);

					}

				}
				try {
					FileOutputStream writeFile = new FileOutputStream("SportsName.xlsx");

					workbook.write(writeFile);

					writeFile.close();
					System.out.println("Sample Excel file is being created Successfully");

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		return PageFactory.initElements(driver, TopMenu.class);

	}
	
}