package poc1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class controller extends webDriver{
	public static void InputBox(String locator, String value){
		WebElement element=driver.findElement(By.xpath(".//input[@type=\""+locator+"\"]"));
		element.sendKeys(value);
	}
	
	public static void ButtonClick(String locator){
		WebElement button=driver.findElement(By.xpath(".//input[@value=\""+locator+"\"]"));
	    button.click();
	}
}
