package TestCases;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.com.Base;
import screens.com.loginScreens;
public class Login_Test_Cases extends Base {
	
	loginScreens LoginScreens;
	
 @Parameters({"Email","password" ,"error_message"})
  @Test(priority=1) 
  public void login_with_credentials(String Email, String password ,String error_message  , Method method) throws Exception  {
	  
 LoginScreens = new loginScreens ();
	  
	  LoginScreens.FinedEmailAndPassword(Email,password);
	  LoginScreens.clicklogin();
	  Thread.sleep(4000);
	  LoginScreens.assert_Login_message(error_message);
}
 
 
  @Parameters({"Email","password" ,"error_message"})
   @Test(priority=2) 
    public void login_with_Enail_Empty(String Email, String password , String error_message)  {
	LoginScreens = new loginScreens ();

	  LoginScreens.FinedEmailAndPassword("", password);
	  LoginScreens.clicklogin();	 
	  LoginScreens.assert_Worng_Email_message(error_message);
	  
}
 
  
 @Parameters({"Email","password" ,"error_message"})
  @Test(priority=3) 
  public void login_with_password_Empty(String Email, String password , String error_message)  {
  LoginScreens = new loginScreens ();

	  LoginScreens.FinedEmailAndPassword(Email, "");
	  LoginScreens.clicklogin();
	  LoginScreens.assert_Worng_Password_message(error_message);
}
}
