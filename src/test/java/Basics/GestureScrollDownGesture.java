package Basics;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class GestureScrollDownGesture {
	
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

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		//ScrollDown Gesture using AndroidUiAutomator google engine 
		
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView3\"))"));
 ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
			ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200,
		    "direction", "down", "percent", 3.0 ));
	
	

}
}