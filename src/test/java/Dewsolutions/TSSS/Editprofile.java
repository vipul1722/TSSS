package Dewsolutions.TSSS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class Editprofile {
	
	WebDriver driver;
	MongoClient mongoClient = null;
	MongoDatabase db = null;
	String otp;
	String mobile="2615241234";
	
	@Test
	public void startbrowser() throws InterruptedException
		
	{

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
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"fname\"]")));

	
	driver.navigate().to("https://sssuat.tataunistore.com/");
	WebElement q=driver.findElement(By.xpath("/html/body/header/div/div[3]/ul/li[2]/a"));
	actions.moveToElement(q).moveToElement(driver.findElement(By.xpath("/html/body/header/div/div[3]/ul/li[2]/div/div[2]/ul/li/a"))).click().build().perform();

	Thread.sleep(2000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,1500)");
	
	
	driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]")).click();
	
	//MongoClient mongoClient = new MongoClient("13.232.125.176", 27017);
	
	
	
	driver.findElement(By.xpath("//a[contains(text(),'Change Mobile Number')]")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(mobile);
	driver.findElement(By.xpath("//button[@id='sendotpProfile']")).click();
	
	
	
	
		String dbURI = "mongodb://sssdb:TatASsdB213@13.232.125.176:27017/sssdb";
		//com.mongodb.client.MongoClient mongoClient=MongoClients.create(dbURI);
		MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		
		DB database = mongoClient.getDB("sssdb");
		
		DBCollection collection = database.getCollection("users");

		
	      
		    BasicDBObject whereQuery = new BasicDBObject();
		    whereQuery.put("email","testtest123@yopmail.com");
		    DBCursor cursor = collection.find(whereQuery);
		    
		    for(     DBObject obj   : cursor)
		    {
		    	String firstname= obj.get("firstname").toString();
		    	System.out.println(firstname);
		    	
		    	 otp=obj.get("phpin").toString();
		    	System.out.println(otp);
		    
		    	}
	
	driver.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
	driver.findElement(By.xpath("//button[@id='profile_SubmitOtp']")).click();

}}
