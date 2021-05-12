package Dewsolutions.TSSS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

public 	WebDriver driver;
public 	Properties prop;
	public WebDriver initializedriver() throws IOException
	{
		
		 prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\rahulshetty\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

			driver = new ChromeDriver();
		}
		
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hp\\eclipse-workspace\\appium\\geckodriver.exe");
					 driver = new FirefoxDriver();		
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}



