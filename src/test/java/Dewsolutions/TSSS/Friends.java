package Dewsolutions.TSSS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Friends {
	
	ExtentReports ex;

	WebDriver driver;
	
	@BeforeMethod
	public void startbrowser() throws InterruptedException
		
	{
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web automation");
		reporter.config().setDocumentTitle("Test result");

		ex = new ExtentReports();                     
		ex.attachReporter(reporter);

		ex.setSystemInfo("Tester", "Vipul");
	}
	
	
	
	
	
	
	
	
	@Test
	public void refer() throws InterruptedException
	
	{
		ex.createTest("friends refer");    //to create a new test

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://sssuat.tataunistore.com/login");
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//label[contains(text(),'Email and Password')]"));

		actions.doubleClick(elementLocator).perform();
		
		driver.findElement(By.xpath("//*[@id=\"principal\"]")).sendKeys("testtest123@yopmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testuser");
		driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
	driver.findElement(By.xpath("//*[@id='fname']")).sendKeys("vipul");
	driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys("aggarwal");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testingautomation@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("3728323232");
	
	Thread.sleep(2000);

	
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	


	}
	
	@AfterMethod
	public void close()
	{
		System.out.println("succseeful");
	}

}

