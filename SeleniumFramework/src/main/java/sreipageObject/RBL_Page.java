package sreipageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RBL_Page {
	private static WebDriver driver;
	private static WebElement element = null;

	public RBL_Page(WebDriver driver) {
		RBL_Page.driver=driver;
	}
	
	public static String ReadBanner() {
		element=driver.findElement(By.xpath(".//div[@class=\"BannerArea Dark_BlueTheme\" or \"BannerArea Light_BlueTheme\"]/h1"));
		return element.getText().toString();
	}
	
	public static String ReadValue() {
		element=driver.findElement(By.xpath(".//div/b"));
		return element.getText();
		
	}
	
	public static String GetPageTitle() {
		String value=driver.getTitle();
		return value;
	}
	
	public static boolean CheckBox(){
		element = driver.findElement(By.xpath(".//input[@id=\"iageee\"]"));
		element.click();
		if(element.isSelected()) {
			return true;
		}
		else 
			return false;
	}
	
	public static void LinkText(String Name) {
		element = driver.findElement(By.xpath(".//a[text()=\""+Name+"\"]"));
		element.click();
	}
	
	public static SKASH_Page Submit(String Name) {
		element = driver.findElement(By.xpath(".//a[@id=\"btnSubmit\" and text()=\""+Name+"\"]"));
		element.click();
		return new SKASH_Page(driver);
	}
	
	public static String VerifyErrorText() {
		element = driver.findElement(By.xpath(".//*[@class=\"subError globalError\"]"));
		return element.getText().toString();
	}
	
	public static void ClosePopUp() {
		element = driver.findElement(By.xpath(".//div[@id=\"ErrorDiv\"]/a"));
		element.click();
	}

}
