package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableValidation {
	
	public static void ReadData(WebDriver driver) {
		List<WebElement> row=driver.findElements(By.xpath(".//*/table/tbody/tr"));
		for(int i=0;i<=row.size();i++) {
			List<WebElement> col=driver.findElements(By.xpath(".//*/table/tbody/tr["+i+"]/td"));
			for(int j=0;j<col.size();j++) {
				System.out.println(col.get(j).getText());
			}
		}
	}
}
