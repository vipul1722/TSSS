package Dewsolutions.TSSS;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.PortableServer.ThreadPolicyOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Employeerefer {




	ExtentReports ex;

	WebDriver driver;
	
	@BeforeMethod
	public void startbrowser1() throws InterruptedException
		
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
	public void startbrowser() throws InterruptedException
		
	{
		ex.createTest("MGM refer");    //to create a new test

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
	
	WebDriverWait wait=new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"myTab\"]/li/a")));


JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,-1000)");


driver.navigate().to("https://sssuat.tataunistore.com/mgmShare");

Thread.sleep(2000);

driver.findElement(By.xpath("//a[@id='hidePopup']")).click();
jse.executeScript("window.scrollBy(0,250)");

	

driver.findElement(By.xpath("//*[@id=\"fname_1\"]")).sendKeys("test");
 

driver.findElement(By.xpath("//*[@id=\"lname_1\"]")).sendKeys("testing");
 driver.findElement(By.xpath("//*[@id=\"email_1\"]")).sendKeys("testdwh@yopmail.com");
driver.findElement(By.xpath("//*[@id=\"phone_1\"]")).sendKeys("2767623626");
Thread.sleep(3000);;
driver.findElement(By.xpath("//*[@id=\"shareConsent\"]")).click();
driver.findElement(By.xpath("//*[@id=\"inviteButton_1\"]")).click();



 

}
}