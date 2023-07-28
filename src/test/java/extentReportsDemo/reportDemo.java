package extentReportsDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reportDemo
{
	ExtentReports extents;
	
	@BeforeTest
	public void config()
	{
		//ExtentReport , 
		//ExtentSparkReport- reponsible to create new file and create some configuration 
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		
		ExtentSparkReporter repoter= new ExtentSparkReporter(path);
		repoter.config().setReportName("Automation report");
		repoter.config().setDocumentTitle("Appium Test Cases Results");
		
		 extents= new ExtentReports();
		extents.attachReporter(repoter);
		extents.setSystemInfo("Tester", "Amar Mali");
		extents.setSystemInfo("Env", "QA");
		
		
	}
	
	
	
	@Test
	public void getTiltle()
	{
		ExtentTest test= extents.createTest("Demo Test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amar.dharmaraj\\eclipse-workspace\\AppiumFrameWork\\src\\main\\java\\utils\\driver\\chromedriver.exe");
		WebDriver driver=  new ChromeDriver();
		driver.get("https:facebook.com");
		String title=driver.getTitle();
		System.out.println(title);
		driver.close();
		test.fail("result not matched");
		
		extents.flush();
	}
	
	
}
