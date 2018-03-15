package MobileApp.MobileApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;



public class App 
{
	WebDriver driver;
	//AppiumDriver driver1;
	public static DesiredCapabilities cap = new DesiredCapabilities();
 
	@BeforeTest
	public void startAppium() throws MalformedURLException, InterruptedException{
		System.out.println("setUP() :: driver.AndroidDriver() executed");
		cap.setCapability("platformName","Android");
		cap.setCapability("deviceName","G2AXB7100875EGE");
		cap.setCapability("appPackage", "com.android.settings");
		cap.setCapability("appActivity", "com.android.settings.Settings"); 
		 driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
 
	@Test(priority=0)
	public void example() throws Exception {
	    // find an element by tag name
	List	<WebElement> switchbtn = driver.findElements(By.className("android.widget.Switch"));
	switchbtn.get(1).click();
			
	 driver.findElement(By.xpath("//android.widget.TextView[@text='Display']")).click();
	 
	 driver.findElement(By.xpath("//android.widget.TextView[@text='Display']")).click();
	/* driver.findElement(By.xpath("//android.widget.TextView[@text='Brightness level']")).click();
	 driver.findElement(By.id("com.android.settings:id/automatic_mode")).click();
	 driver.findElement(By.xpath("//android.widget.Button[@text='Cancel']")).click();
	 
	 driver.findElement(By.xpath("//android.widget.TextView[@text='Brightness level']")).click();
	 driver.findElement(By.id("com.android.settings:id/automatic_mode")).click();
	 driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
	 
	 driver.findElement(By.xpath("//android.widget.TextView[@text='Brightness level']")).click();
	 driver.findElement(By.id("com.android.settings:id/automatic_mode")).click();
	 driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();*/
	 driver.findElement(By.xpath("//android.widget.TextView[@text='Brightness level']")).click();
	}


	@Test(priority=1)
	public void testSeekBar()throws  Exception
	
	{
		AndroidDriver<WebElement> drivera = null;
		//Locating seekbar using resource id
		WebElement seek_bar=driver.findElement(By.className("android.widget.SeekBar"));
		// get start co-ordinate of seekbar
		int start=seek_bar.getLocation().getX();
		//Get width of seekbar
		int end=seek_bar.getSize().getWidth();
		//get location of seekbar vertically
		int y=seek_bar.getLocation().getY();

		
		System.out.println("X :"+start+ "," + "width :"+end+ "," +"Y :"+y);

		// Select till which position you want to move the seekbar
		TouchAction action=new TouchAction(drivera);
		
		//Move it will the end
		action.press(start,y).moveTo(end,y).release().perform();

		//Move it 70%
	//	int moveTo=(int)(end*0.7);
	//	System.out.println(moveTo);

	//	action.press(start,y).moveTo(200,y).release().perform();
		 driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();

	}
}
