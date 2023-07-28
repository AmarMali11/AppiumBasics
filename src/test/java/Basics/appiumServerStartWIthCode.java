package Basics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appiumServerStartWIthCode 
{

	@Test
	public void appiumBasicTest() throws MalformedURLException, InterruptedException
	{

		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\amar.dharmaraj\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) 
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		Thread.sleep(10000);		
		
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("MyMob");
		options.setApp("C:\\Users\\amar.dharmaraj\\eclipse-workspace\\Appium\\src\\main\\java\\utils\\ApiDemos-debug.apk");
		Thread.sleep(5000);		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		//Actual Automation with diffenrent diffenrent locators
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/widget_frame")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String altertText=driver.findElement(By.id("android:id/alertTitle")).getText();
		org.testng.Assert.assertEquals(altertText, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Marve01");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		driver.quit(); 
		service.stop();

		
	}
}
