package TestAppium;
import org.testng.annotations.Test;

import browserstack.shaded.org.json.JSONObject;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class NewTest {  
	public static final String userName = "sathishsampath_JubATq";
    public static final String accessKey = "Uq9x97ridnhU7JqwZxsp";
    public static final String url = "https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
    public static AndroidDriver driver;
    public static IOSDriver iOSdriver;
         
	@BeforeMethod
	public void beforeTest() throws MalformedURLException {
		iOSDriver();  	
	  }
	  
	public void androidDriver() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
	  	caps.setCapability("deviceName", "Google Pixel 3");
	  	caps.setCapability("os_version", "9.0");
	  	caps.setCapability("Project", "Appium Mobile Automation Demo");
	  	caps.setCapability("Build", "5.1");
	  	caps.setCapability("name", "Browser stack sample demo");
	  	caps.setCapability("app", "bs://ddef4110238a452d9864518fc29eff3c9425f9e4");
	  	
	  	System.out.println(url);
	  	driver = new AndroidDriver(new URL(url),caps);
	}
	
	public void iOSDriver() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
	  	caps.setCapability("deviceName", "iphone 13");
	  	caps.setCapability("os_version", "16");
	  	caps.setCapability("Project", "Appium Mobile Automation Demo");
	  	caps.setCapability("Build", "1.1");
	  	caps.setCapability("name", "Browser stack iOS demo");
	  	caps.setCapability("app", "bs://030a99b3d037ef2f74189b8dc78c4ed5674c98d4");
	  	
	  	System.out.println(url);
	  	iOSdriver = new IOSDriver(new URL(url),caps);
	}
	  @Test
	  public void loginApp() {		  
		 
		  List<WebElement> list = iOSdriver.findElements(By.name("Text Button"));
		  
		  for (WebElement ele:list) {
			  System.out.println(ele.getAttribute("text"));
		  }
	  }
	
	  @AfterMethod
	  public void afterTest() {
		  iOSdriver.close();
	  }

}
