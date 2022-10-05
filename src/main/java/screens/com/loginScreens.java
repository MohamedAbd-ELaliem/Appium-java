package screens.com;
import javax.print.DocFlavor.STRING;

import org.testng.Assert;

import base.com.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class loginScreens extends Base {
	
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@text='Enter your Email']")
	private MobileElement EmailF;
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@text='Enter your Password']")
	private MobileElement passwordF;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Login']")
	private MobileElement login;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='All Tasks']")
  	private MobileElement Login_message;
	
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='The email address is badly formatted.']")
  	private MobileElement Worng_Email_message;
	

	@AndroidFindBy(xpath ="//android.widget.TextView[@text='The password is invalid or the user does not have a password.']")
  	private MobileElement Worng_password_message;
	
	
	
          	public void FinedEmailAndPassword(String Email , String password ) {
            	EmailF.sendKeys(Email);
	            passwordF.sendKeys(password);		
		
}
	
	        public void clicklogin() {
	        	login.click();
	
}
	
	
	        public void assert_Login_message(String error_message) {
	        String actual_message_title= Login_message.getText();
	        Assert.assertEquals(actual_message_title, "All Tasks" ,error_message);
}
	       
	        public void assert_Worng_Email_message (String error_message) {
		        String actual_message_title= Worng_Email_message.getText();
		        Assert.assertEquals(actual_message_title, "The email address is badly formatted." ,error_message);  
	       
}
	        public void assert_Worng_Password_message (String error_message) {
		        String actual_message_title=  Worng_password_message.getText();
		        Assert.assertEquals(actual_message_title, "The password is invalid or the user does not have a password." ,error_message);  
	       
	        
	        
	     }
	    
	   }
