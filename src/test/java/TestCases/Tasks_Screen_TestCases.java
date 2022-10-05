package TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.com.Base;
import screens.com.NewTaskScreen;
import screens.com.TaskScreens;
import screens.com.loginScreens;


public class Tasks_Screen_TestCases extends Base{
	
	TaskScreens taskScreens;
	loginScreens LoginScreens;
	NewTaskScreen newTaskScreen;
	
	
	
	 @Parameters({"Email","password",})
	  @Test(priority=1) 
	  public void press_logout_from_Tasks_Screen(String Email , String Password) throws Exception {
		  LoginScreens = new loginScreens ();
		  newTaskScreen = new NewTaskScreen();
		  taskScreens = new TaskScreens();
		  
		  LoginScreens.FinedEmailAndPassword(Email, Password);
		  LoginScreens.clicklogin();
		  Thread.sleep(3000);
		  newTaskScreen.clicklogout();
		  newTaskScreen.assert_click_logout();
		  
 }
	  
	 @Parameters({"Email","password","AddTask"})
	  @Test(priority=2) 
	  public void Add_New_Task(String Email,String Password ,String AddTask) throws InterruptedException {
		  LoginScreens = new loginScreens ();
		  newTaskScreen = new NewTaskScreen();
		  taskScreens = new TaskScreens();
		  
		  LoginScreens.FinedEmailAndPassword(Email, Password);
		  LoginScreens.clicklogin();
		  Thread.sleep(6000);
		  newTaskScreen.clickAddnewTask();
          taskScreens.EnterNewTask(AddTask);
          Thread.sleep(2000);
          newTaskScreen.clickAddnewTask();
          taskScreens.CheckTask();
		  
	  }
	  
	 @Parameters({"Email","password"})

	@Test(priority=3) 
	  public void Check_current_tasks (String Email,String Password) throws InterruptedException {
		  taskScreens = new TaskScreens();
		  LoginScreens = new loginScreens ();
		  newTaskScreen = new NewTaskScreen();
		  taskScreens = new TaskScreens();
		  LoginScreens.FinedEmailAndPassword(Email, Password);
		  LoginScreens.clicklogin();
		  Thread.sleep(3000);
          taskScreens.CheckTask();
	  }
	 
}
