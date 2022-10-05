package screens.com;

import base.com.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TaskScreens extends Base{
	
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@text='Enter a new Task']")
	private MobileElement EnterNewTask;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Logout']")
	private MobileElement clicklogout;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Task']")
	private MobileElement CheckTask;
	
	
	
	
	
	

public void EnterNewTask(String Task) {
	EnterNewTask.sendKeys(Task);
}

  public void CheckTask() {
	 CheckTask.isDisplayed();
}
	
	

}
