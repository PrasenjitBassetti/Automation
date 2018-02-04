package sreipageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SKASH_Page {

	private static WebDriver driver;
	private static WebElement element = null;
	
	public SKASH_Page(WebDriver driver) {
		SKASH_Page.driver=driver;
	}
	
	public static String ReadBanner() {
		element=driver.findElement(By.xpath(".//div[@class=\"BannerArea Light_BlueTheme\"]/h1"));
		return element.getText().toString();
	}
	
	public static String CheckAmount() {
		element=driver.findElement(By.xpath(".//div[contains(@class,\"UserDetails\")][1]"));
		return element.getText().toString();
	}
	
	public static String CheckVLE() {
		element = driver.findElement(By.xpath(".//div[contains(@class,\"UserDetails\")][2]"));
		return element.getText().toString();
	}
	
	public static void Pin(WebDriver driver,String Value) {
		element = driver.findElement(By.xpath(".//input[contains(@type,\"pass\")]"));
		element.sendKeys(Value);
	}
	
	public static void Pay(WebDriver driver) {
		element = driver.findElement(By.xpath(".//a[text()=\" Pay\"]"));
		element.click();
	}
	
	

}
