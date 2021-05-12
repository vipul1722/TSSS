 package Dewsolutions.TSSS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Negativetestcase {
	
	
	WebDriver driver;

	@Test
	public void refer() throws InterruptedException
	
	{

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://sssuat.tataunistore.com/login");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
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
	
	WebDriverWait wait = new WebDriverWait(driver,40);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	String text=driver.findElement(By.xpath("//*[@id=\"shareForm\"]/div/div[4]/div")).getText();
	System.out.println(text);
	
	Assert.assertEquals(text, "Please enter valid Mobile number");
	
	
	

		
}}
