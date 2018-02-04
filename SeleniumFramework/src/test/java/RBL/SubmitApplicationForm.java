package RBL;

import org.testng.annotations.Test;

import sreipageObject.Home_Page;
import sreipageObject.RBL_Page;
import sreipageObject.SKASH_Page;
import sreipageObject.SREILogin_Page;
import testdrive.TestBaseSetup;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;

public class SubmitApplicationForm extends TestBaseSetup{
private WebDriver driver;
	
	@BeforeClass()
	public void setUp() {
		driver=getDriver();
	}

	
	@Test(priority=1,description="Go to RBL Aeps Registration Page")
	public void OpenRegistrationPage() {
		try {
			SREILogin_Page.Username(driver, "1028040203000001");
			SREILogin_Page.Password(driver, "Sahaj@123");
			SREILogin_Page.Signin(driver);
			Thread.sleep(3000);
			SREILogin_Page.ClosePopUp(driver, "I am not GST registered");
			Thread.sleep(1000);
			SREILogin_Page.ClosePopUp(driver, "SKIP to Home Page");
			Thread.sleep(2000);
			Home_Page.RBL_AEPS(driver,"Submit Application fees");
			Thread.sleep(3000);
			Assert.assertEquals(RBL_Page.GetPageTitle(), "RBL - Sahaj-Uat");
			Assert.assertEquals(RBL_Page.ReadBanner(), "RBL AEPS REGISTRATION");
			Thread.sleep(3000);
		}
		catch(Exception e){
			System.out.println(e); 
		}
		
	}
	
	@Test(priority=2,description="Pay AEPS Registration Button will be diactivate until Checking the box")
	public void PayAEPSRegButtonDeactivation() {
		try {
			Thread.sleep(3000);
			RBL_Page.Submit("Pay AEPS Registration fees");
			Thread.sleep(2000);
			Assert.assertEquals(RBL_Page.VerifyErrorText(), "Please select check box for declaration");
			RBL_Page.ClosePopUp();
			Thread.sleep(3000);
		}
		catch(Exception e){
			System.out.println(e); 
		}
	}
	
	@Test(priority=3,description="Click Here Link")
	public void ClickHereLink() {
		try {
			RBL_Page.LinkText(" Click here");
			Thread.sleep(8000);
			changeTab();
			
		}
		catch(Exception e){
			System.out.println(e); 
		}
	}
	
	@Test(priority=4,description="Terms & Conditions Checkbox checking")
	public void TCCheckBoxCheck() {
		try {
			Assert.assertEquals(RBL_Page.CheckBox(), true);
			Thread.sleep(2000);
		}
		catch(Exception e){
			System.out.println(e); 
		}
		
	}
	
	@Test(priority=5,description="Click on Pay AEPS Registration Fees")
	public void PayRegistrationFees() {
		try {

			RBL_Page.Submit("Pay AEPS Registration fees");
			Thread.sleep(6000);
			Assert.assertEquals(SKASH_Page.ReadBanner(), "SKASH DEDUCTION");
			Assert.assertEquals(SKASH_Page.CheckAmount(), "7000.00");
			Assert.assertEquals(SKASH_Page.CheckVLE(), "1028040203000001");
			SKASH_Page.Pin(driver, "1234");
			SKASH_Page.Pay(driver);
			Thread.sleep(3000);
			Assert.assertTrue(RBL_Page.ReadValue().contains("Transaction successful"));
			Home_Page.LogOut(driver);
			Thread.sleep(4000);
		}
		catch(Exception e){
			System.out.println(e); 
		}
		
	}
	

}
