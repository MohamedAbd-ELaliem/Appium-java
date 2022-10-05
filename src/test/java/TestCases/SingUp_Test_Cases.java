package TestCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.com.Base;
import screens.com.SinupScreens;


public class SingUp_Test_Cases  extends Base{
	SinupScreens sinupScreens;

	
@Parameters({"Email","password" ,"Test"})
@Test (priority=1) 
  public void singup_with_ValidData(String Email, String password, String Test) throws Exception  {
  sinupScreens = new SinupScreens ();
  
	 sinupScreens.clickSingup();
	  Thread.sleep(4000);

     sinupScreens.Find_Name_Email_Password_For_Singup(Test ,Email , password);
     sinupScreens.clickSignupConfirm();
	  Thread.sleep(4000);
	    String expectedMessage = "All Tasks";
	     String message = driver.findElementByXPath("//android.widget.TextView[@text='All Tasks']").getText();
	     Assert.assertEquals(expectedMessage, message);  
	     
	     } 


/**@Test(priority=2) 
 public void click_Login_from_SingupPage()  {
 sinupScreens = new SinupScreens ();

     sinupScreens.clickSingup();
     sinupScreens.clicklogin();
	       
} 
 @Test(priority=3) 
  public void Singup_WithOut_Email()  {
 sinupScreens = new SinupScreens ();

	  sinupScreens.clickSingup();
	  sinupScreens.Find_Name_Email_Password_For_Singup("Appium","", "123456");
	  sinupScreens.clickSignupConfirm();

 }
**/
 }
