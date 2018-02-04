package RBL;

import org.testng.annotations.Test;

import sreipageObject.Home_Page;
import sreipageObject.RBL_Page;
import sreipageObject.SREILogin_Page;
import testdrive.TestBaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;


public class DuplicateApplicationForm extends TestBaseSetup {
	private WebDriver driver;
 
  @BeforeClass
  public void setUp() {
		driver=getDriver();
	}
 

    @Test(priority=1,description="Go to Duplicate Application Page")
	public void DuplicateFormUnpaid() {
		try {
			SREILogin_Page.Username(driver, "1028040203000001");
			SREILogin_Page.Password(driver, "Sahaj@123");
			SREILogin_Page.Signin(driver);
			Thread.sleep(3000);
			SREILogin_Page.ClosePopUp(driver, "I am not GST registered");
			Thread.sleep(1000);
			SREILogin_Page.ClosePopUp(driver, "SKIP to Home Page");
			Thread.sleep(2000);
			Home_Page.RBL_AEPS(driver, "Duplicate Application form");
			Assert.assertEquals(RBL_Page.ReadValue(), "You have not paid application fees.");
			Thread.sleep(2000);
			Home_Page.LogOut(driver);
		}
		catch(Exception e) {
			System.out.println(e);
		}
    }
		
		@Test(priority=2, description="Go to Duplicate Application Page")
		  public void DuplicateFormPaid() {
			  try {
				  SREILogin_Page.Username(driver, "1919010100002661");
					SREILogin_Page.Password(driver, "Sahaj@123");
					SREILogin_Page.Signin(driver);
					Thread.sleep(2000);
					SREILogin_Page.ClosePopUp(driver, "SKIP to Home Page");
					Thread.sleep(1000);
					SREILogin_Page.ClosePopUp(driver, "Cancel");
					SREILogin_Page.AlertWindow(driver);
					Home_Page.RBL_AEPS(driver, "Duplicate Application form");
					Assert.assertTrue(RBL_Page.ReadValue().contains("Transaction successful"));
					Thread.sleep(2000);
					Home_Page.LogOut(driver);
			  }
			  catch(Exception e) {
				  System.out.println(e);
			  }
}
		
}
