package AndroidBrowserHandling;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class OpenChromeInAndroid {

	@Test
	public void openChrome() throws Throwable
	{
		//to start appium server from local machine
		 AppiumDriverLocalService service	 = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\amar.dharmaraj\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) 
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		Thread.sleep(10000);
		
		// to connect with andorid emulator and Android SDK
		
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("MyMob");
		option.setChromedriverExecutable("C:\\Users\\amar.dharmaraj\\eclipse-workspace\\Appium\\src\\main\\java\\utils\\chromedriver.exe");
		option.setCapability("browserName", "Chrome");
		
		// to Run android driver		
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		driver.get("https://google.com");
		Thread.sleep(9000);
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Apple Mobile Search");
		System.out.println("Send key in search box");
		Thread.sleep(9000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		
		
		
	}
	
	
}
