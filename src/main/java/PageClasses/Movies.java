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

public class Movies extends BaseUi {
	WebDriver driver;
	public TopMenu topMenu;

	ArrayList<String> moviesLanguages;

	@FindBy(xpath = "//*[@id='super-container']/div[2]/div[4]/div[2]/div[2]/div/div[2]/a[1]/div/div[2]/div/img")
	WebElement comingSoon;

	public Movies(WebDriver driver) {
		this.driver = driver;
		topMenu = PageFactory.initElements(driver, TopMenu.class);

	}

	
	public TopMenu fetchAllMoviesLanguages() {
		waits(3000);
		comingSoon.click();
		List<WebElement> languages = driver.findElements(By.xpath("//*[@class=\"style__StyledText-tgsgks-0 cAIFpf\"]"));
		for (int i = 0; i < languages.size(); i++) {
			System.out.println(languages.get(i).getText());
		}
		// create excelSheet
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet samplesheet = workbook.createSheet("SampleSheet");
		
		//create data
		Map<String, Object[]> dataSet = new TreeMap<String, Object[]>();
		dataSet.put("0", new Object[] { "ID", "Lang" });
		
//		for(int i = 0; i<languages.size(); i++) {
//			dataSet.put("2", new Object[] { i , languages.get(i).getText()});
//			dataSet.put("3", new Object[] { i , languages.get(i).getText()});
//			}
		
		for(int i = 0; i<languages.size(); i++) {
		dataSet.put(""+i+1, new Object[] { i , languages.get(i).getText()});
		}
		
		//Iterate over the data
		Set<String> set = dataSet.keySet();
		int rownum = 0;

		for (String key : set) {

			Row row = samplesheet.createRow(rownum++);

			Object[] data = dataSet.get(key);

			int cellNum = 0;

			for (Object value : data) {

				Cell cell = row.createCell(cellNum++);

				if (value instanceof String)
					cell.setCellValue((String) value);
				else if (value instanceof Integer)
					cell.setCellValue((Integer) value);

			}

		}
		try {
			FileOutputStream writeFile = new FileOutputStream("MoviesName.xlsx");

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