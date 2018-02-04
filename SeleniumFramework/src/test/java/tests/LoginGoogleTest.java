package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Login_Page;
import testdrive.TestBaseSetup;

public class LoginGoogleTest extends TestBaseSetup {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver=getDriver();
	}
	
	
	@Test
	public void loginGoogle() {
		try {
			Login_Page.Username(driver, "prasenjit2012.khardah@gmail.com");
			Login_Page.ClickAt(driver,"Next");
			Thread.sleep(10000);
			Login_Page.Password(driver, "Prasanta@1995");
			Login_Page.ClickAt(driver,"Next");
			Thread.sleep(10000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
