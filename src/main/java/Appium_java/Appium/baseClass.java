package Appium_java.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * Hello world!
 *
 */
public class baseClass 

{
	public AndroidDriver driver;
	public AppiumDriverLocalService service;


	@BeforeClass
	public void appiumBasicConfiguration() throws InterruptedException, MalformedURLException
	{

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\amar.dharmaraj\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) 
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();		
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("MyMob");
		options.setApp("C:\\Users\\amar.dharmaraj\\eclipse-workspace\\Appium\\src\\main\\java\\utils\\ApiDemos-debug.apk");
		options.setChromedriverExecutable("C:\\Users\\amar.dharmaraj\\eclipse-workspace\\Appium\\src\\main\\java\\utils\\chromedriver.exe");

		Thread.sleep(5000);		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void longClickGestureAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementID",((RemoteWebElement)ele).getId(),"duration",5000));
	}


	public void scrollStillEndAction()
	{
		boolean canScrollMore;
		do {		
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200,
							"direction", "down", "percent", 3.0 ));

		} while (canScrollMore);	

	}



	public void dragAndDrop(WebElement element,int X_axis,int Y_axis)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"endX", X_axis,
				"endY", Y_axis
				));
	}



	public void swipeAction(WebElement element,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"direction", direction,
						"percent", 0.75

						));

	}



	public void setAppPackageAndAppActivity(String appPackageName, String appActivityName)
	{
		Activity act= new Activity(appPackageName,appActivityName);
		driver.startActivity(act);
	}

	public void validateFirstToastErrorText(String expectedFirstToastErrorText)
	{
		WebElement toastError=driver.findElement(By.xpath("(//android.widget.Toast)[1]"));
		String errorText=toastError.getAttribute("name");
		Assert.assertEquals(errorText, expectedFirstToastErrorText);
	}

	public Double DoubleproductPrice(String priceInString)
	{	
				
		Double ammount=Double.parseDouble(priceInString.substring(1));
		return ammount;
	}

	
	public void ScreenRotate(int X_axis, int Y_axis, int Z_axis) throws InterruptedException
	{
		DeviceRotation landScape= new DeviceRotation(X_axis,Y_axis,Z_axis);
		driver.rotate(landScape);
		Thread.sleep(5000);
	}
	
	


	@AfterClass
	public void tearDown()
	{


		driver.quit(); 
		service.stop();

	}


}
