package ajayacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportPractice {

	ExtentReports extent;
	
	@BeforeTest
	public void extentReport()
	{
		// ExtentReports and //EntentSparkReporter
		String path = System.getProperty("user.dir")+ "\\Reports1\\Report1.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Testing Report");
		reporter.config().setDocumentTitle("Test Report");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Project Lead", "Ajay Gupta");
		extent.setSystemInfo("Senior Tester", "Melissa Morissey");
	}
		
	@Test
	
	public void invokeApp()
	{
		extent.createTest("Initial Test");
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium with Java\\Software Installs_IMP\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		extent.flush();
	}
	
}
