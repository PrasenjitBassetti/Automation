package testdrive;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import ru.yandex.qatools.allure.annotations.Attachment;

public class TestBaseSetup {

	private static WebDriver driver;
	static String driverPath = System.getProperty("user.dir")+"\\driver\\";
	static String PropertyFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	
	public static WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}


	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		//ChromeDriverManager.getInstance().setup();
		System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		//FirefoxDriverManager.getInstance().setup();
		//System.getProperty("user.dir")+"\\driver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath
				+ "geckodriver.exe");
		/*System.setProperty("webdriver., driverPath
				+ "chromedriver.exe");*/
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	
	public static void autoComplete_selectOptionWithText(String textToSelect,WebElement autoOptions) {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 10000);
			wait.until(ExpectedConditions.elementToBeClickable(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public static Properties readFile(){
		
		File file = new File(PropertyFilePath);
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static void changeTab() {
		ArrayList<String> tab= new ArrayList<String> (driver.getWindowHandles());
		try {
			driver.switchTo().window(tab.get(1));
			driver.close();
			driver.switchTo().window(tab.get(0));			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void Scroll() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		 // This  will scroll down the page by  1000 pixel vertical		
	     js.executeScript("window.scrollBy(0,100)");
	}
	
	@Attachment
	public static byte[] makeScreenshot() {
		byte[] file = ((TakesScreenshot) getDriver())
				.getScreenshotAs(OutputType.BYTES);
		System.out.print(file.toString());
		System.out.println("under @Attachment blog");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}


	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void WaitUntil(WebDriver driver,int i,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
		
	
}