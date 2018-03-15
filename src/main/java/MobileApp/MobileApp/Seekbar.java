package MobileApp.MobileApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Seekbar {

	WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("deviceName", "ZY223ZKZ33");

		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", "com.android.settings.Settings");
		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(priority=1)
	public void Setting() throws Exception {
		//	 driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();
		//	 driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Display']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Brightness level']")).click(); 

	}
	AndroidDriver  driver1;
	
	@Test(priority=2)
   
	public void ScrollToView() {

		// Click on Seek Bar.
		//driver.findElement(By.id("com.android.systemui:id/slider")).click();
		driver.findElement(By.xpath("//android.widget.SeekBar[@text='Display brightness']")).click();		
		//Locate SeekBar element.
		WebElement seekBar=   driver.findElement(By.xpath("//android.widget.SeekBar[@text='Display brightness']"));

		//Get start point of seekbar.
		int startX = seekBar.getLocation().getX();
		System.out.println(startX);
		//Get end point of seekbar.
		int endX = seekBar.getSize().getWidth();
		System.out.println(endX);
		//Get vertical location of seekbar.
		int yAxis = seekBar.getLocation().getY();

		//Set sllebar move to position. 
		//endX * 0.6 means at 60% of seek bar width.
		int moveToXDirectionAt = (int) (endX * 0.6);
		System.out.println("Moving seek bar at " + moveToXDirectionAt+" In X direction.");

		//Moving seekbar using TouchAction class.
		//	  TouchAction act=new TouchAction(driver1);  
		//	  act.press(startX,yAxis).moveTo(moveToXDirectionAt,yAxis).release().perform();  
		// Select till which position you want to move the seekbar
		TouchAction action=new TouchAction(driver1);

		//Move it will the end
		action.press(startX,yAxis).moveTo(endX,yAxis).release().perform();

		//Move it 40%
		int moveTo=(int)(endX*0.4);
		action.longPress(startX,yAxis).moveTo(moveToXDirectionAt,yAxis).release().perform();
	}

	@Test(priority=0)

	public void More() {

		driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='More']")).click();		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Mobile networks']")).click();		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preferred network type']")).click();		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='3G']")).click();	
		//cancel button
		// driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL']")).click();	
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preferred network type']")).click();		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='LTE (recommended)']")).click();	
		//back button
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();		 
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();		 
	}

	@AfterTest
	public void End() throws IOException {
		driver.quit();

	}
}

