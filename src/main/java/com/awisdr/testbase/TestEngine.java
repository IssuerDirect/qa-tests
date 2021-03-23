package com.awisdr.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.awisdr.utils.ConfigsReader;
import com.awisdr.utils.Constants;

public class TestEngine {

	protected static WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browserName", "ApplicationType" })
	public void setUp(String browserName, String ApplicationType) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Extent-Test-Results.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest(this.getClass().getSimpleName(), "Executed Test Steps");
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Accesswire ISDR Extent Report");
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (browserName.toLowerCase()) {

		case "chrome":
			extent.setSystemInfo("Browser", "Chrome");
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
			driver = new ChromeDriver();
			test.log(Status.PASS, "Chrome Browser Launched Successfully");

			break;
		case "firefox":
			extent.setSystemInfo("Browser", "FireFox");
			System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		case "edge":
			extent.setSystemInfo("Browser", "Edge");
			System.setProperty("webdriver.edge.driver", Constants.EDGEDRIVER_PATH);
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		
		switch (ApplicationType) {
		case "client":
			driver.get(ConfigsReader.getPropValue("clientURL"));
			test.log(Status.PASS,"Navigated to URL : "+ConfigsReader.getPropValue("clientURL"));
			break;
		case "admin":
			driver.get(ConfigsReader.getPropValue("adminURL"));
			test.log(Status.PASS,"Navigated to URL : "+ConfigsReader.getPropValue("adminURL"));
			break;

		default:
			break;
		}
		


		PageInitializer.initializePageObjects();
	}

	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		if (driver != null) {
			driver.quit();
		}
		extent.flush();
	}

}
