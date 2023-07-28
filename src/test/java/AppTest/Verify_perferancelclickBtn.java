package AppTest;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Appium_java.Appium.baseClass;
import io.appium.java_client.AppiumBy;

public class Verify_perferancelclickBtn extends baseClass {

	@Test
	public void clickonPreference() throws MalformedURLException, InterruptedException
	{

		driver.findElement(AppiumBy.accessibilityId("Preference")).click();



	}



}
