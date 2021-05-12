package Dewsolutions.TSSS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class NewUser {


	WebDriver driver;

	MongoClient mongoClient = null;
	MongoDatabase db = null;
	String otp;
	String emailid="kkdhjhshkh@yopmail.com";
	String mobile="3727656747";

	
	@Test
	public void startbrowser() throws InterruptedException, IOException
		
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	driver = new ChromeDriver(options);
	driver.get("https://sssuat.tataunistore.com/signup");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//*[@id=\"fname\"]")).sendKeys("testtesttest");
	driver.findElement(By.xpath("//*[@id=\"lname\"]")).sendKeys("useruseruser");
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailid);
	driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys(mobile);
	Thread.sleep(3000);

	driver.findElement(By.xpath("//*[@id=\"signup\"]/div[8]/input")).click();
	Thread.sleep(3000);
	/*
	 * driver.findElement(By.xpath("//a[contains(text(),'Company Email Address')]"))
	 * .click(); Thread.sleep(2000);
	 * driver.navigate().to("http://www.yopmail.com/en/");
	 * driver.findElement(By.xpath("//input[@id='login']")).sendKeys(
	 * "tetwetete@yopmail.com");
	 * driver.findElement(By.xpath("//input[@value='Check Inbox']")).click();
	 */
	
	driver.findElement(By.xpath("//a[contains(text(),'Company ID Card')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='dz-default dz-message']")).click();

	Thread.sleep(2000);

	Runtime.getRuntime().exec("C:\\Users\\Hp\\Documents\\fileupload.exe");
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//*[@id=\"tata_id_submit\"]")).click();
	
	//driver.switchTo().alert().sendKeys("78787");
	
	Thread.sleep(3000);
	
	//MongoClient mongoClient = new MongoClient("13.232.125.176", 27017);
	
	String dbURI = "mongodb://sssdb:TatASsdB213@13.232.125.176:27017/sssdb";
	//com.mongodb.client.MongoClient mongoClient=MongoClients.create(dbURI);
	MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
	
	DB database = mongoClient.getDB("sssdb");
	
	DBCollection collection = database.getCollection("users");

	
      
	    BasicDBObject whereQuery = new BasicDBObject();
	    whereQuery.put("email",emailid);
	    DBCursor cursor = collection.find(whereQuery);
	    
	    for(     DBObject obj   : cursor)
	    {
	    	String firstname= obj.get("firstname").toString();
	    	System.out.println(firstname);
	    	
	    	 otp=obj.get("phpin").toString();
	    	System.out.println(otp);
	    
	    	}
driver.findElement(By.xpath("//*[@id=\"otp\"]")).sendKeys(otp);

driver.findElement(By.xpath("//*[@id=\"otpPopUpBoxSubmitPreLog\"]")).click();

Thread.sleep(2000);


driver.findElement(By.xpath("//*[@id=\"loginPassword\"]")).sendKeys("testetst");

driver.findElement(By.xpath("//*[@id=\"loginCPassword\"]")).sendKeys("testetst");

driver.findElement(By.xpath("//*[@id=\"setPassword\"]")).click();

Thread.sleep(2000);


driver.findElement(By.xpath("//a[contains(text(),'Enter the Site')]")).click();


	
	
	
	
	
	
	}}
	
