package listeners.com;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TesListeners implements ITestListener {
	
	
	public void onTestFailure(ITestResult result ) {
		if(result.getThrowable() != null) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		result.getThrowable().printStackTrace(pw);
		System.out.println("Ops Test Cases Is Failure Because" + sw.toString());

		}
					
	
}
	
}	
