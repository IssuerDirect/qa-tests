package com.awisdr.testcases;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.awisdr.testbase.ActionEngine;
import com.awisdr.testbase.PageInitializer;
import com.awisdr.utils.ConfigsReader;
import com.awisdr.utils.Constants;

public class VerifyPressReleaseCreationFunctionality extends ActionEngine {
	@BeforeMethod(alwaysRun = true)
	public void setUp() {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getPropValue("browser").toLowerCase()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKODRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", Constants.EDGEDRIVER_PATH);
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}

		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getPropValue("clientURL"));
		PageInitializer.initializePageObjects();
	}
	@Test(groups = { "c", "VerifyPressReleaseCreationFunctionality" })
	public void verifyPressReleaseCreationFunctionality()
			throws AWTException, InterruptedException, FileNotFoundException, IOException {

		
		  login.validateClientLoginScreen();
		 login.loginToClientApplication(ConfigsReader.getPropValue("clientUsername"),
		  ConfigsReader.getPropValue("clientPassword"));
		 pressReleasePage.clickPressRelease();
		 pressReleasePage.clickcontinueWithCollaboration();
		 pressReleasePage.enterHeadLine();
		  pressReleasePage.getTextFromTextFile(); pressReleasePage.uploadVideoLink();
		  pressReleasePage.getTextFromTextFile();
		  pressReleasePage.uploadFileWithRobot1(); pressReleasePage.insertTable();
		  pressReleasePage.saveAsDraft();
		  pressReleasePage.enterNext();
		  pressReleasePage.pressRelaeseTypeDrpdwn();
		  pressReleasePage.selectdate();
		  pressReleasePage.nextpagesecond();
		  pressReleasePage.clickOnMediaTargeting();
		  pressReleasePage.nextpageThird();
		  pressReleasePage.finalStepOnSubmit();
		  
		  

	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws IOException {
		if (driver != null) {
			driver.quit();
			 Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		}
}
}
