package GeneralHybridApp;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class VerifyTotalPriceInCard {

	@Test
	public void VerifyProductPrice() throws Throwable {
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\amar.dharmaraj\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("MyMob");
		options.setApp(
				"C:\\Users\\amar.dharmaraj\\eclipse-workspace\\Appium\\src\\main\\java\\utils\\General-Store.apk");
		Thread.sleep(5000);
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		// Actual automation code

		Thread.sleep(5000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("General App");
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);

		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		List<WebElement>productsInCard=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int productCount=productsInCard.size();
		double totalPriceSum=0; 
		for(int i=0;i<productCount;i++)
		{ 
			String priceText=productsInCard.get(i).getText();
			System.out.println("Product pric :"+priceText);
			String priceWithoutSpecialChar=priceText.substring(1); // Double.parseDouble(priceText.substring(1)) to remove dollar sign from string $140.45 form zero index 
			Double price=Double.parseDouble(priceWithoutSpecialChar); 

			totalPriceSum=totalPriceSum+price;

		}
		System.out.println(totalPriceSum);
		String totalPriceStringInCard=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		String priceWithoutSpecialChar=totalPriceStringInCard.substring(1);		
		Double totalPrice=Double.parseDouble(priceWithoutSpecialChar);
		System.out.println(totalPrice);
		//Assert.assertEquals(totalPriceSum, totalPrice);


	}
}
