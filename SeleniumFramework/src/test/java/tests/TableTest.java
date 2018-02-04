package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import elements.TableValidation;
import testdrive.TestBaseSetup;

public class TableTest extends TestBaseSetup {
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		this.driver=getDriver();
	}
	
  @Test
  public void f() {
	TableValidation.ReadData(driver);
  }
}
