package Dewsolutions.TSSS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting {
	
	ExtentReports ex;

	@BeforeTest
	public void test() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web automation");
		reporter.config().setDocumentTitle("Test result");

		ex = new ExtentReports();                     
		ex.attachReporter(reporter);

		ex.setSystemInfo("Tester", "Vipul");
	}

	@Test
	public void testing() {
		ex.createTest("login");    //to create a new test
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.goibibo.com");
		ex.flush();   //erasde any previous test
	}
}


