package Com.facebook.Auto.Training;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Common.browsers;

public class App extends browsers implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			screenshots("C:\\Users\\HASSEN\\workspace\\Training\\Pass\\");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			screenshots("C:\\Users\\HASSEN\\workspace\\Training\\fail\\");
			System.out.println("the screenshot is stored in : Training\\fail folder");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
		
	}
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(("onTestFailedWithTimeout for " + result.getMethod().getMethodName()));
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
			
	}

	public void onFinish(ITestContext context) {
		
		
	}
    
}
