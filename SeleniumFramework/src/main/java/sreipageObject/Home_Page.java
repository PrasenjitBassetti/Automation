package sreipageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Home_Page {
	private static WebDriver driver;
	private static WebElement element = null;

	public Home_Page(WebDriver driver) {
		Home_Page.driver=driver;
	}
	
	public static String PageTitle() {
		String pageTitle=driver.getTitle();
		return pageTitle;
	}
	
	public static RBL_Page RBL_AEPS(WebDriver driver,String LinkName) {
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(".//span[text()=\" Financial Inclusion\"]"))).moveToElement(driver.findElement(By.xpath(".//a[text()=\"AEPS\"]"))).moveToElement(driver.findElement(By.xpath(".//a[text()=\"RBL\"]"))).moveToElement(driver.findElement(By.xpath("//*[@id='menu']/ul/li[7]/ul/li[7]/ul/li/ul/li[3]/a"))).click().build().perform();
		return new RBL_Page(driver);
		}
	
	public static SREILogin_Page LogOut(WebDriver driver) {
		element=driver.findElement(By.linkText("Sign Out"));
		element.click();
		return new SREILogin_Page();
	}
}
