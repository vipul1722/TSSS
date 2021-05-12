package Dewsolutions.TSSS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Leadsubmission {
	

	WebDriver driver;
	
	@Test
	public void startbrowser() throws InterruptedException
		
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	driver = new ChromeDriver(options);
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
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"fname\"]")));
	
	driver.navigate().to("https://sssuat.tataunistore.com/");
	
	Select drpCountry = new Select(driver.findElement(By.xpath("//select[@class='custom-select brandSelect']")));
	drpCountry.selectByVisibleText("Tata Housing");
	
	driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-lg Discover']")).click();
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)");
	
	driver.findElement(By.linkText("Avail")).click();
	Thread.sleep(2000);;
	
	WebElement key= driver.findElement(By.xpath("//span[contains(text(),'Select Project')]"));
	key.click();
	Thread.sleep(2000);
driver.findElement(By.xpath("//label[contains(text(),'Eureka Park | Noida')]")).click();

driver.findElement(By.xpath("//span[contains(text(),'City where I reside')]")).click();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("//label[contains(text(),'Agra')]")).click();

driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

	
	}
	
	

}
