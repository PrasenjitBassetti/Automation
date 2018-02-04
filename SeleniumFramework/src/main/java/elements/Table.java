package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Table {
	private WebElement element=null;
	private WebDriver driver;
	
	public Table(WebDriver driver) {
		this.driver=driver;
	}
	
	public String ReadData(int RowIndex,int ColIndex) {
		element = driver.findElement(By.xpath(".//*/tbody/tr["+RowIndex+"]/td["+ColIndex+"]"));
		return element.getText();
	}
}
