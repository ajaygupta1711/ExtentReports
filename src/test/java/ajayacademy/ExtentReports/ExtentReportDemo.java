package ajayacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent;
	
		@BeforeTest
		public void config()
		{
			// ExtentReports and ExtentSparkReporter
			
			String Path = System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(Path);
			reporter.config().setReportName("Web Automation Results");
			reporter.config().setDocumentTitle("Test Results");
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("QA Test Lead", "Ajay Gupta");
			extent.setSystemInfo("Senior Tester", "Aarav Gupta");
		}
	
	
		@Test
		public void initialDemo()
		{
			extent.createTest("Initial Demo");
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium with Java\\Software Installs_IMP\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/");
			System.out.println(driver.getTitle());
			extent.flush();
		}


}
