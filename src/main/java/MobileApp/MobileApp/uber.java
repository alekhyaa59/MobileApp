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

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidDriver;

	public class uber {

		WebDriver driver;

		@BeforeTest
		public void setUp() throws Exception {

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName","Android");
			capabilities.setCapability("deviceName", "ZY223ZKZ33");

			capabilities.setCapability("appPackage", "com.ubercab.eats");
			capabilities.setCapability("appActivity", "com.ubercab.eats.app.feature.launch.LobbyActivity");
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}

		@Test(priority=0)
		public void DeliveryLocation() throws Exception {
			driver.findElement(By.id("com.android.launcher3:id/icon")).click();
			driver.findElement(By.id("com.ubercab.eats:id/ub__lobby_continue_as_email")).click();
			driver.findElement(By.id("com.ubercab.eats:id/ub__locationsearch_edittext_search")).sendKeys("s");
			
			driver.findElement(By.id("com.ubercab.eats:id/ub__locationsearch_edittext_search")).sendKeys("s");
	
			WebElement element = driver.findElement(By.id("com.ubercab.eats:id/ub__locationsearch_edittext_search"));
			element.sendKeys("K");
			int x = element.getLocation().getX();
			int y = element.getLocation().getY();

			System.out.println("X value: "+x+" Y value: "+y);
			Thread.sleep(2000);

			TouchAction action = new TouchAction((PerformsTouchActions) driver).tap(x+60, y+260).release();
			action.perform();

			//If need to enter few more data in to text field, again send it by using sendKeys method and perform the action
			element.sendKeys("Ko");
			Thread.sleep(2000);
			action.perform();
			

		}


	/*	@Test(priority=0)

		public void More() {

			driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='More']")).click();		
			driver.findElement(By.xpath("//android.widget.TextView[@text='Mobile networks']")).click();		
			driver.findElement(By.xpath("//android.widget.TextView[@text='Preferred network type']")).click();		
			driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='3G']")).click();	
		}
*/
		@AfterTest
		public void End() throws IOException {
			driver.quit();

		}
	}
