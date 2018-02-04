package tests;


import org.apache.commons.collections4.functors.ExceptionTransformer;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import check.BasePage;
import check.SignInPage;
import listeners.OnFailure;
import testdrive.TestBaseSetup;


@Listeners({ OnFailure.class })
public class SignInPageTest extends TestBaseSetup{
private WebDriver driver;
private SignInPage signInPage;
private BasePage basePage;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
	}
		
	@Test
	public void verifySignInFunction() {
		try {
		System.out.println("Sign In functionality details...");
		basePage = new BasePage(driver);
		signInPage = basePage.clickSignInBtn();
		Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
		Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
		Assert.assertTrue(signInPage.verifySignIn(), "Unable to sign in");
		}
		catch(Exception e)
		{
			throw e;
		}

	}

}