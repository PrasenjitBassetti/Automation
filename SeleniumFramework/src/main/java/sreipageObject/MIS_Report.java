package sreipageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MIS_Report {
	 private static WebDriver driver;

	public MIS_Report(WebDriver driver) {
		 MIS_Report.driver=driver;
	 }
	
	public static String ReadBanner() {
		WebElement element = driver.findElement(By.xpath(".//div[@class=\"BannerArea Light_BlueTheme\"]"));
		return element.getText().toString();
	}
	
	public static void LinkText(String Name)
	{
		driver.findElement(By.xpath(".//li[@class='selected level1-li']//a[text()='MIS Report']")).click();
	}
}
