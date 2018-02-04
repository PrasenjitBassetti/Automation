package listeners;



import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import testdrive.TestBaseSetup;

public class OnFailure extends TestListenerAdapter {
	
    @Override
    public void onTestFailure(ITestResult tr) {
    	TestBaseSetup.makeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
    	TestBaseSetup.makeScreenshot();
    }
   
	}


