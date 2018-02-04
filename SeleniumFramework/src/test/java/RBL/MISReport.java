package RBL;

import org.testng.annotations.Test;

import listeners.OnFailure;
import sreipageObject.Home_Page;
import sreipageObject.RBL_Page;
import sreipageObject.SREILogin_Page;
import testdrive.TestBaseSetup;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({ OnFailure.class })
public class MISReport extends TestBaseSetup{
	private WebDriver driver;
	 
  @BeforeClass
  public void setUp() {
		driver=getDriver();
	}

  
  @Test (priority=1,description="Go to MIS Report page")
  public void MISReportPage() {
	  try {
		  SREILogin_Page.Username(driver, "sougata.mitra");
		  SREILogin_Page.Password(driver, "Sahaj@123");
		  SREILogin_Page.Signin(driver);
		  WaitUntil(driver,2,SREILogin_Page.elem(driver));
		  Scroll();
		  Thread.sleep(2000);
		  Home_Page.RBL_AEPS(driver, "MIS Report");
		  Thread.sleep(20000);
		  Assert.assertEquals(RBL_Page.ReadBanner(), "MIS Report");
	  }
	  catch(Exception e) {
		  e.printStackTrace();
		  
	  }
  }
 
  
}
