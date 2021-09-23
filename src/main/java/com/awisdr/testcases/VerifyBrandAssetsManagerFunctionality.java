package com.awisdr.testcases;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.awisdr.testbase.ActionEngine;
import com.awisdr.testbase.PageInitializer;
import com.awisdr.testbase.TestEngine;
import com.awisdr.utils.ConfigsReader;
import com.awisdr.utils.Constants;
import com.codoid.products.exception.FilloException;

public class VerifyBrandAssetsManagerFunctionality extends ActionEngine {

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException {
		/*
		 * ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		 * 
		 * switch (ConfigsReader.getPropValue("browser").toLowerCase()) {
		 * 
		 * case "chrome": System.setProperty("webdriver.chrome.driver",
		 * Constants.CHROMEDRIVER_PATH); driver = new ChromeDriver(); break; case
		 * "firefox": System.setProperty("webdriver.gecko.driver",
		 * Constants.GECKODRIVER_PATH); driver = new FirefoxDriver(); break; case
		 * "edge": System.setProperty("webdriver.edge.driver",
		 * Constants.EDGEDRIVER_PATH); driver = new EdgeDriver(); break; default: throw
		 * new RuntimeException("Browser is not supported"); }
		 * driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME,
		 * TimeUnit.SECONDS);
		 * 
		 * driver.manage().window().maximize();
		 * driver.get(ConfigsReader.getPropValue("clientURL"));
		 * PageInitializer.initializePageObjects();
		 */
	}

	@Test(groups = { "smoke", "VerifyBrandAssetsManagerFunctionality" })
	public void verifyBrandAssetsManagerFunctionality()
			throws AWTException, InterruptedException, FileNotFoundException, IOException, FilloException {

		login.validateClientLoginScreen();
		login.loginToClientApplication(ConfigsReader.getPropValue("clientUsername"),
				ConfigsReader.getPropValue("clientPassword"));
		brandAssetsManagerPage.setUploadDocumentData();
		login.applicationLogoutLink();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws IOException {
		if (driver != null) {
			driver.quit();

		}
	}
}
