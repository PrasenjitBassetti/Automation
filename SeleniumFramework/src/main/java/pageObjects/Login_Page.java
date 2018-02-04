package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import check.BasePage;
import sreipageObject.Home_Page;

public class Login_Page 
{
	private static WebElement element;

	public static void Username(WebDriver driver,String value) {
		element = driver.findElement(By.xpath(".//input[@id=\"email\"] | .//input[@type=\"text\"]"));
		element.sendKeys(value);
	}
	
	public static void Password(WebDriver driver,String Value) {
		element = driver.findElement(By.xpath(".//input[contains(@type,\"pass\")]"));
		element.sendKeys(Value);
	}
	
	public static void Login(WebDriver driver) {
		element = driver.findElement(By.xpath(".//input[@value=\"Log In\"]"));
		element.click();
	}

	public static void ClickAt(WebDriver driver, String Value) {
		element = driver.findElement(By.xpath(".//span[text()=\""+Value+"\"]"));
		element.click();		
	}	
}
