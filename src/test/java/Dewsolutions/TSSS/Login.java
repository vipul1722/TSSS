package Dewsolutions.TSSS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;

	
	@BeforeMethod
	public void test()
	
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	
	@DataProvider(name="input")
	public Object[][] getdata()
	{
		
		Object[][] data = new Object[3][2];
		
		data[0][0]="kamran.sheikh8285@gmail.com";
		data[0][1]="12345678";
		data[1][0]="vipula@dewsolutions.in";
		data[1][1]="password";
		data[2][0]="dabang1@yopmail.com";
		data[2][1]="12345678";
		
		return data;
		
	}
		
	@Test(dataProvider="input")
	public void startbrowser(String username, String password) throws InterruptedException
		
	{
		{
			//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			//driver = new ChromeDriver();
			driver.get("https://sssuat.tataunistore.com/login");
			driver.manage().window().maximize();
			
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			
			Actions actions = new Actions(driver);
			WebElement elementLocator = driver.findElement(By.xpath("//label[contains(text(),'Email and Password')]"));

			actions.doubleClick(elementLocator).perform();
			
			driver.findElement(By.xpath("//*[@id=\"principal\"]")).sendKeys(username);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
			driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
			}
	}}


	


