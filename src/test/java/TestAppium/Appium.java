package TestAppium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium {
	
  public static AndroidDriver driver;
  @Test
  public void launchMobileBrowser() {
	  try {
		  DesiredCapabilities capabilities= new DesiredCapabilities();
		  capabilities.setCapability("chromedriverExecutable","C:\\Users\\sathi\\eclipse-workspace\\AppiumAutomation\\driver\\chromedriver.exe");
//		// set the capability to execute test in chrome browser
//		  capabilities.setPlatform(Platform.ANDROID);
//		  capabilities.setVersion("15.0.0");
//		  capabilities.setBrowserName(BrowserType.CHROME);
//		  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"my phone");
		 		 
		 // Create object of URL class and specify the appium server address
		 //URL url= new URL("http://localhost:4723/wd/hub");
		 
		// Create object of  AndroidDriver class and pass the url and capability that we created
		 //WebDriver driver = new AndroidDriver(url, capabilities);
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\sathi\\eclipse-workspace\\AppiumAutomation\\driver\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver(capabilities);
		 
		// Open url
		  driver.get("http://www.amazon.com");
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 // print the title
		  System.out.println("Title "+driver.getTitle());
		 
		// enter username
//		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
//		 
//		// enter password
//		driver.findElement(By.id("ap_email")).sendKeys("vanthana049@gmail.com");
//		driver.findElement(By.id("continue")).click();		
//		driver.findElement(By.id("password")).sendKeys("Hubby#1991");
//		driver.findElement(By.id("signInSubmit")).click();
		 
		// click on submit button
		//driver.findElement(By.id("u_0_5")).click();
		 
		// close the browser
		driver.quit();		 
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
  }
  
  @Test
  public void verifyNativeMobileApp() {
	// Create object of DesiredCapabilities class                             

	  DesiredCapabilities capabilities = new DesiredCapabilities();

	  // Optional
	  capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

	  // Specify the device name (any name)
	  capabilities.setCapability("deviceName", "My New Phone");

	  // Platform version
	  capabilities.setCapability("platformVersion", "4.4.2");

	  // platform name
	  capabilities.setCapability("platformName", "Android");

	  // specify the application package that we copied from appium
	  capabilities.setCapability("appPackage", "io.selendroid.testapp");

	  // specify the application activity that we copied from appium
	  capabilities.setCapability("appActivity", ".HomeScreenActivity");

	   
	  // Start android driver I used 4727 port by default it will be 4723
	  try {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"), capabilities);
		// Specify the implicit wait of 5 second
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		  // Enter the text in textbox
		  driver.findElement(By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']")).sendKeys("Mukesh Selenium Appium");

		  // click on registration button	                                     
		  driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();

		  // Wait for 10 second
		  Thread.sleep(10000);

		  // close the application
		   driver.quit();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	}  
}
