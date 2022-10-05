package screens.com;

import base.com.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SinupScreens extends Base {
	
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='Signup']")
	private MobileElement signup;
	@AndroidFindBy(xpath ="//android.widget.TextView[@bounds='[163,1371][917,1424]']")
	private MobileElement signupConfirm;
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@text='Enter your Full name']")
	private MobileElement EnterName;
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@bounds='[[144,1143][1296,1346]']")
	private MobileElement EnterEmail;
	
	@AndroidFindBy(xpath ="//android.widget.EditText[@bounds='[144,1416][1296,1619]']")
	private MobileElement EnterPassword;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@bounds='[214,1983][1226,2049]']")
	private MobileElement login;
	

public void clickSingup( ) {
	signup.click();
}

public void Find_Name_Email_Password_For_Singup(String Name ,String Email , String password ) {
	EnterName.sendKeys(Name);
	EnterEmail.sendKeys(Email);
	EnterPassword.sendKeys(password);

}

public void clicklogin( ) {
	login.click();
	
}
public void clickSignupConfirm( ) {
	signupConfirm.click();


}
}