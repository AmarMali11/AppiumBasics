package Basics;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscellanousActivitiesUsingAppium 
{

	@Test
	public void appiumBasicTest() throws MalformedURLException, InterruptedException
	{

		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\amar.dharmaraj\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		Thread.sleep(9000);
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("MyMob");
		options.setApp(
				"C:\\Users\\amar.dharmaraj\\eclipse-workspace\\Appium\\src\\main\\java\\utils\\ApiDemos-debug.apk");
		Thread.sleep(5000);
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		//Actual Automation with diffenrent diffenrent locators
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		
		// Rotation of mobile screen
		DeviceRotation landScape= new DeviceRotation(0,0,90);
		driver.rotate(landScape);
		Thread.sleep(5000);
		
		
		driver.findElement(By.id("android:id/widget_frame")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		

		//copy paste
		//copy to clipboard
		driver.setClipboardText("Marvelo1 wifi");		
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		///Click button or press Key 
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));


		
	}
}
