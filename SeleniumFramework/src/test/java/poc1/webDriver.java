package poc1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webDriver {
	
	static WebDriver driver;
	
	public static void Launch(String BrowserName) {
		if(BrowserName == "chrome") {
			System.setProperty("webdriver.chrome.driver",".\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		if(BrowserName == "mozilla") {
			System.setProperty("webdriver.gecko.driver",".\\geckodriver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
	}
	
	public static void Maximize(){
		driver.manage().window().maximize();
		
	}
	
	public static void OpenURL(String URL){
		driver.get(URL);
	}
	
	public static void close(){
		driver.close();
	}
	
	public static void SwitchToAlertWindow(){
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}

}
