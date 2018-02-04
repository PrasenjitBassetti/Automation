package poc1;

public class FirstCase {

	public static void main(String[] args) throws InterruptedException  {
		webDriver.Launch("chrome");
		webDriver.Maximize();
		webDriver.OpenURL("https://p3uat.sahaj.co.in:8080/web/guest/home");
		controller.InputBox("text","1001011200002998");
		controller.InputBox("password","Password@1234");
		controller.ButtonClick("Sign In");
		Thread.sleep(5000);
		controller.ButtonClick("I am not GST registered");
		controller.ButtonClick("SKIP to Home Page");
		Thread.sleep(10000);
		controller.ButtonClick("Cancel");
		webDriver.SwitchToAlertWindow();
		Thread.sleep(10000);
		webDriver.close();
		
		

	}

}