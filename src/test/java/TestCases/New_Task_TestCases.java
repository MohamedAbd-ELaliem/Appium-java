package TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.com.Base;
import screens.com.NewTaskScreen;
import screens.com.loginScreens;

public class New_Task_TestCases extends Base{
	     loginScreens LoginScreens; 
	     NewTaskScreen newTaskScreen;
	     
 @Parameters({"Email","password"})
 @Test(priority=1) 
  public void click_Add_New_Task(String Email, String password) throws Exception  {
	  LoginScreens = new loginScreens ();
	  newTaskScreen = new NewTaskScreen();
	  
	  LoginScreens.FinedEmailAndPassword(Email, password);
	  LoginScreens.clicklogin();
	  Thread.sleep(3000);
	  newTaskScreen.clickAddnewTask();
	  newTaskScreen.assert_click_addnew_Task();
	  
  }

 @Parameters({"Email","password"})
  @Test(priority=2) 
  public void press_logout(String Email, String password) throws Exception   {

	  LoginScreens = new loginScreens ();
	  newTaskScreen = new NewTaskScreen();
	  
	  LoginScreens.FinedEmailAndPassword(Email, password);
	  LoginScreens.clicklogin();
	  Thread.sleep(3000);
	  newTaskScreen.clicklogout();
	  newTaskScreen.assert_click_logout();

  }  
}
