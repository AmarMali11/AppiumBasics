package GeneralHybridApp;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class toastErrorMessage {

	
	@Test
	public void VerifyToastErrorMessageForEnterName() throws Throwable
	{
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\amar.dharmaraj\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) 
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("MyMob");
		options.setApp("C:\\Users\\amar.dharmaraj\\eclipse-workspace\\Appium\\src\\main\\java\\utils\\General-Store.apk");
		Thread.sleep(5000);		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		// Actual Automation code
		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// Toast message handing --> Xpath is fixed in all andorid version only index value changes depending on number od error toast error 
	
		WebElement toastError=driver.findElement(By.xpath("(//android.widget.Toast)[1]"));
		String errorText=toastError.getAttribute("name");
		Assert.assertEquals(errorText, "Please enter your name");
		
	}
	
	
	
}
