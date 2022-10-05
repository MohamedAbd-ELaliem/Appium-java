package base.com;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import atu.testrecorder.ATUTestRecorder;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;


public class Base {
	protected static  AndroidDriver <MobileElement> driver ;
	public static     ExtentReports extent;
	public static     ExtentTest logger;
	protected         ATUTestRecorder   recorder;
	protected         FileInputStream InputStream;
	protected         Properties prop;
	
 
	// (page object) // making method Element  //screens
	public Base ()
	  {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
      }
	
	
	@Parameters({"deviceName","platformVersion","platformName"})
	@BeforeMethod
	   public void beforeClass(String deviceName,String platformVersion ,String platformName , Method metod) throws  Exception {
				
		logger = extent.startTest(metod.getName());
		// reading from Config file
		  File proFil = new File("src/main/resources/config.properties");
		  InputStream = new FileInputStream(proFil);
		  prop= new Properties();
		  prop.load(InputStream);
		  
		  
		  if(deviceName.equalsIgnoreCase("Android")) {
			   File andriodapp = new File(prop.getProperty("androidAppLocation"));
			  DesiredCapabilities caps = new DesiredCapabilities();
			  caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			  caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			  caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			  caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("androidAutomationName"));
			  caps.setCapability(MobileCapabilityType.APP, andriodapp.getAbsolutePath());
			  driver = new AndroidDriver  <MobileElement> (new URL(prop.getProperty("appiumURL")) , caps);
	          recorder = new ATUTestRecorder ("/home/mabdelalim/eclipse-workspace/Appium_Demo_FormWork/Repoerts",metod.getName(),  false);
			  recorder.start();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			  
	   	     }else if (deviceName.equalsIgnoreCase("ios")){
			  
			  File iosapp = new File(prop.getProperty("iosAppLocation"));
			  DesiredCapabilities caps = new DesiredCapabilities();
			  caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			  caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			  caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			  caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("androidAutomationName"));
			  caps.setCapability(MobileCapabilityType.APP, iosapp.getAbsolutePath());
			  driver = new AndroidDriver  <MobileElement> (new URL(prop.getProperty("appiumURL")) , caps);
		      recorder = new ATUTestRecorder ("/home/mabdelalim/eclipse-workspace/ToDoFormWork1/Video",".mov",  false);
			  recorder.start();
			   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
}}
		  
	@AfterMethod
	  public void AfterClass (ITestResult result ,Method method   ) throws Exception  {
		Thread.sleep(2000);
		File source=((TakesScreenshot)driver).getScreenshotAs (OutputType. FILE);
		FileUtils.copyFile(source, new File("/home/mabdelalim/eclipse-workspace/Appium_Demo_FormWork/Repoerts",method.getName()+".png"));
         driver.quit();          
	   recorder.stop();
	   
	  
	    if(result.getStatus() == ITestResult.SUCCESS) 
		 	{
	    	
		        logger.log(LogStatus.PASS,result.getName()+ " is pass");
		 		logger.log(LogStatus.PASS, "<a href='" + result.getName() + ".png" + "' target='_blank'><span class='lable info'>Download Snapshot</span></a>");
		 		logger.log (LogStatus.PASS,"<a href='" + result.getName() + ".mov" +"' target='_blank'><span class='lable info'>Download Video</span></a>");
		 		
		 	} 
		 	else if (result.getStatus() == ITestResult. FAILURE) 
		 	{
		 		logger.log(LogStatus.FAIL, result.getName()+"Test is Fail");
				logger.log (LogStatus.FAIL, result.getThrowable() );

				logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".png" + "' target='_blank'><span class='lable info'>Download Snapshot</span></a>");
		 		logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".mov" + "' target='_blank'><span class='lable info'>Download Video</span></a>");
			} 
		 	else
		 	{
				logger.log (LogStatus.SKIP, "Test Skipped");
						   
} 
	     
}
	
	@BeforeSuite
    public void BeforeeClass () {
		extent = new ExtentReports("Repoerts/index.html");
		extent.addSystemInfo("Framwork Type","Appium With Java"); 
		extent.addSystemInfo("Author", "Mohamed Abd El-Aliem");
		extent.addSystemInfo("Environment", "Android");
		extent.addSystemInfo("App", "ToDo");
   	 
    }
	@AfterSuite
    public void AfddderClass () {
		extent.flush();
		
  }
	
}
