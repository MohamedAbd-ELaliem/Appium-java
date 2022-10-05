package screens.com;

import org.testng.Assert;

import base.com.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewTaskScreen extends Base {
	
	

	@AndroidFindBy(uiAutomator ="text(\"Add new Task\")")
	private MobileElement clickAddnewTask;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Logout']")
	private MobileElement clicklogout;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Back']")
	private MobileElement assert_click_addnew_Task;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Login']")
	private MobileElement assert_click_logout;
	
	
	
	

public void clickAddnewTask() {
	clickAddnewTask.click();
}

public void clicklogout() {
	clicklogout.click();
}


public void assert_click_addnew_Task () {
	 assert_click_addnew_Task.isDisplayed();

}

public void assert_click_logout () {
	assert_click_logout.isDisplayed();
}}
