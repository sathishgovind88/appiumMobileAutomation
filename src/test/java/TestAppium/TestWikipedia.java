package TestAppium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofMillis;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestWikipedia {
	
	public static final String userName = "sathishsampath_JubATq";
    public static final String accessKey = "Uq9x97ridnhU7JqwZxsp";
    public static final String url = "https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
    public static AndroidDriver driver;
    public static IOSDriver iOSdriver;
    
    final By title = AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title");
    final By view = AppiumBy.className("android.view.View");
    final By dev = AppiumBy.xpath("//android.widget.TextView[@text='developers']");
    
    @BeforeMethod
	public void beforeTest() throws MalformedURLException {
		androidDriver();	
	}
	  
	public void androidDriver() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
	  	caps.setCapability("deviceName", "Google Pixel 3");
	  	caps.setCapability("os_version", "9.0");
	  	caps.setCapability("Project", "Appium Mobile Automation Demo");
	  	caps.setCapability("Build", "5.1");
	  	caps.setCapability("name", "Automation Wikipedia mobile app");
	  	caps.setCapability("app", "bs://30b5cdeb2e8c4e4dd3471413eb9190cb9d69be5e");
	  	
	  	System.out.println(url);
	  	driver = new AndroidDriver(new URL(url),caps);	  	
	}
  
	@SuppressWarnings("rawtypes")
	@Test
	  public void verifyWikipedia() throws InterruptedException {
		  WebElement skipButton = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
          ExpectedConditions.presenceOfElementLocated(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")));
	      skipButton.click();
	      	
	      WebElement searchElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
	      ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Search Wikipedia")));
	      
	      List<WebElement> allProductsName = driver.findElements(AppiumBy.className("android.widget.TextView"));
	      Assert.assertTrue(allProductsName.size() > 0);
	      	      	      
	      searchElement.click();
	      WebElement insertTextElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
	      ExpectedConditions.elementToBeClickable(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
	      insertTextElement.sendKeys("BrowserStack");
	      Thread.sleep(3000);	
	      
	      //driver.findElement(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
	      driver.findElement(title).click();
	      Thread.sleep(1000);
	      	      	      
	      //allProductsName = driver.findElements(AppiumBy.className("android.view.View"));
	      allProductsName = driver.findElements(view);
	      Assert.assertTrue(allProductsName.size() > 0);
	      	      
	      System.out.println(driver.manage().window().getSize());
	     	      	      
	        new TouchAction(driver)
	                .press(PointOption.point(500, 1600))
	                .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
	                .moveTo(PointOption.point(500, 1000))
	                .release().perform();
	        
	        new TouchAction(driver)
            .press(PointOption.point(500, 1000))
            .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
            .moveTo(PointOption.point(500, 1600))
            .release().perform();
	        
	        driver.findElement(dev).click();
	        
	        new TouchAction(driver).longPress(PointOption.point(500, 1000)).release().perform();
	        
	  }
	  
	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }

}
