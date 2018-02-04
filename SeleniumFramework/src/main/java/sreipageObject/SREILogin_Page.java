package sreipageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.Login_Page;

public class SREILogin_Page extends Login_Page{
	private static WebElement element=null;
	
	public static  Home_Page Signin(WebDriver driver) {
		element=driver.findElement(By.xpath(".//input[@value=\"Sign In\"]"));
		element.click();
		return new Home_Page(driver);
	}
	
	public static void ClosePopUp(WebDriver driver,String Value) {
		element=driver.findElement(By.xpath(".//input[@value=\""+Value+"\"]"));
		element.click();
			
	}
	
	public static void AlertWindow(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	} 
	
	public static  WebElement elem(WebDriver driver) {
		WebElement e= driver.findElement(By.linkText("Sign Out"));
		return e;
		
	}
	
	
	/*public static Home_Page Signin(WebDriver driver) {
		element=driver.findElement(By.xpath(".//input[@value=\"Sign In\"]"));
		element.click();
		if(((WebElement) Dialog).isDisplayed()) {
			element=driver.findElement(By.xpath(".//input[@value=\"I am not GST registered\"]"));
			element.click();
			//Thread.sleep(2000);
			element = driver.findElement(By.xpath(".//input[@value=\"SKIP to Home Page\"]"));
			element.click();
			return new Home_Page(driver);
		}
		
		return new Home_Page(driver);
	}*/
}
