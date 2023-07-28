package Basics;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class GesturesLongClickGesture {

	@Test
	public void gestures() throws Throwable {
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\amar.dharmaraj\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		Thread.sleep(9000);
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("MyMob");
		options.setApp(
				"C:\\Users\\amar.dharmaraj\\eclipse-workspace\\Appium\\src\\main\\java\\utils\\ApiDemos-debug.apk");
		Thread.sleep(5000);
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		// Getures for Log press

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement ele = driver.findElements(By.className("android.widget.TextView")).get(1);
		  
	 ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",3000));
		  
	String MenuText=driver.findElement(By.id("android:id/title")).getText();
	Assert.assertEquals(MenuText, "Sample menu");
	Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
	
	
	}

}
