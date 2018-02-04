package tests;

import pageObjects.Login_Page;
import testdrive.TestBaseSetup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginFacebookTest extends TestBaseSetup {
	private WebDriver driver;
	
	@BeforeClass
	public void setup() {
		this.driver=getDriver();
	}
	
	@Test
	public void log() {
		try {
			Login_Page.Username(driver,"jeletmark395@yahoo.com");
			Login_Page.Password(driver,"Manforcecondom");
			Login_Page.Login(driver);
			Thread.sleep(10000);
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		
	}

}