package com.awisdr.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.awisdr.utils.ConfigsReader;
import com.awisdr.utils.Constants;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.codoid.products.exception.FilloException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import com.codoid.products.exception.FilloException;

public class BaseClass {

	protected static WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	/*
	 * @BeforeMethod(alwaysRun = true) public void setUp() {
	 * 
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
	 * 
	 * // driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME,
	 * TimeUnit.SECONDS); driver.get(ConfigsReader.getPropValue("clientURL"));
	 * PageInitializer.initializePageObjects(); }
	 * 
	 * @AfterMethod(alwaysRun = true) public void tearDown() { if (driver != null) {
	 * driver.quit(); } }
	 */

	/*
	 * 
	 * @Author: SreeGuntaka Feature : Generic
	 * 
	 * @Description: This method Initiate Browser Driver Ex: initializeDriver()
	 * 
	 * public WebDriver initializeDriver() throws IOException { try { clearLogs();
	 * String browserName = readPropertiesFile("browser",
	 * "//src//main//resources//data.properties"); String workingDirChrome =
	 * System.getProperty("user.dir"); Path filePathChrome =
	 * Paths.get(workingDirChrome + File.separator + "//chromedriver.exe");
	 * 
	 * if (browserName.equals("chrome")) {
	 * System.setProperty("webdriver.chrome.driver", filePathChrome.toString());
	 * ChromeOptions options = new ChromeOptions();
	 * options.setExperimentalOption("useAutomationExtension", false); driver = new
	 * ChromeDriver(options); driver.manage().deleteAllCookies();
	 * driver.manage().window().maximize(); } else if
	 * (browserName.equals("firefox")) { //todo } else if (browserName.equals("IE"))
	 * { //todo } driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }
	 * catch(Exception e) { System.out.println("Exception occured due to : " +
	 * e.toString()); } return driver; }
	 * 
	 * @Author: SreeGuntaka Feature : Generic
	 * 
	 * @Description: This method Launch browser with the specified URL Ex:
	 * initiateBorwserDriver()
	 * 
	 * 
	 * 
	 * public WebDriver initiateBorwserDriver() throws
	 * IOException,InterruptedException { try { Thread.sleep(5000);
	 * closeAllBrowsers(); driver = initializeDriver();
	 * log.info("Driver is initialized"); String browserName =
	 * readPropertiesFile("urlsit", "//src//test//resources//url.properties");
	 * driver.get(browserName); log.info("Navigatted to Home page"); }
	 * catch(Exception e) { System.out.println("Exception occured due to : " +
	 * e.toString()); } return driver; }
	 */

	/*
	 * public Properties loadProperites() throws Exception{ Properties pro = new
	 * Properties(); String filePath =
	 * System.getProperty("user.dir")+"allure.properties";
	 * System.out.println("Printing the file path from loadProperties method "
	 * +filePath); File src = new File(filePath); FileInputStream fis = new
	 * FileInputStream(src); pro.load(fis); return pro; }
	 */
	/*
	 * @Author: SreeGuntaka Feature : Generic
	 * 
	 * @Description: This method reads the data from the Property file which is
	 * attached in the project location Ex: readPropertiesFile(String strGetValue,
	 * String strLocation)
	 */
	public String readPropertiesFile(String strGetValue, String strLocation) throws IOException {
		String browserName = null;
		try {
			Properties prop = new Properties();
			String workingDir = System.getProperty("user.dir");
			Path filePath = Paths.get(workingDir + File.separator + strLocation);
			FileInputStream fls = new FileInputStream(filePath.toFile());
			prop.load(fls);
			browserName = prop.getProperty(strGetValue);
		} catch (Exception e) {
			System.out.println("Exception occured due to : " + e.toString());
		}
		return browserName;
	}

	/*
	 * @Author: SreeGuntaka Feature : Generic
	 * 
	 * @Description: Close existing browsers Ex: closeAllBrowsers()
	 */
	public void closeAllBrowsers() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
	}

	/*
	 * @Author: SreeGuntaka Feature : Generic
	 * 
	 * @Description: Delete all downloaded files Ex: clearDownLoadedFIles()
	 */
	public void clearDownLoadedFIles() {
		try {
			Path filePath = Paths.get("C://Users//" + System.getProperty("user.name") + "//Downloads//");
			File dir = new File(filePath.toFile().toString());
			File[] dirContents = dir.listFiles();
			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().startsWith("definition-")
						|| dirContents[i].getName().contains("COVERSHEET") || dirContents[i].getName().contains("SCT")
						|| dirContents[i].getName().contains("RCL") || dirContents[i].getName().contains("CICL")
						|| dirContents[i].getName().contains("CRL") || dirContents[i].getName().contains("STATISTICS")
						|| dirContents[i].getName().contains("VALIDATIONREPORT")
						|| dirContents[i].getName().contains("DEF")) {
					// File has been found, it can now be deleted:
					dirContents[i].delete();
				} else {
					// System.out.println("File is not downloaded");
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured due to : " + e.toString());
		}
	}

	/*
	 * @Author: SreeGuntaka Feature : Generic
	 * 
	 * @Description: Captures screenshot if test case failed Ex:
	 * captureScreenshot(WebDriver driver, String strTestCaseName)
	 */
	public static String captureScreenshot(WebDriver driver, String strTestCaseName) {
		String dest = null;
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			dest = System.getProperty("user.dir") + "\\reports\\" + strTestCaseName + ".png";
			FileUtils.copyFile(source, new File(dest));
			System.out.println("Screenshot taken successfully");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		return dest;
	}

	/*
	 * @Author: SreeGuntaka Feature : Generic
	 * 
	 * @Description: Verifies if the file is donwloaded then return boolean value
	 * Ex: isFileDownloaded(String strType)
	 */
	public Boolean isFileDownloaded(String strType) {
		Boolean bStatus = false;
		try {
			Path filePath = Paths.get("C://Users//" + System.getProperty("user.name") + "//Downloads//");
			File dir = new File(filePath.toFile().toString());
			File[] dirContents = dir.listFiles();
			for (int i = 0; i < dirContents.length; i++) {
				if (dirContents[i].getName().startsWith(strType)) {
					if (dirContents[i].getName().startsWith(strType)) {
						System.out.println("File is downloaded");
						dirContents[i].delete();
						bStatus = true;
					}
				} else if (dirContents[i].getName().contains(strType)) {

					log.info("File is downloaded");
					dirContents[i].delete();
					bStatus = true;
				} else {
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured due to : " + e.toString());
		}
		return bStatus;
	}

	/*
	 * @Author: SreeGuntaka Feature : Generic
	 * 
	 * @Description: clears log files Ex: clearLogs()
	 */
	public void clearLogs() {
		try {
			String workingDir = System.getProperty("user.dir");
			Path filePath = Paths.get(workingDir + "//logs//");

			String pathToDel = filePath.toString();
			File file = new File(pathToDel);
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.isFile() && f.exists()) {
					f.delete();
					// System.out.println("successfully deleted");
				} else {
					// System.out.println("cant delete a file due to open or error");
				}
			}
		} catch (Exception e) {
			System.out.println("Exception occured due to : " + e.toString());
		}
	}
	

}
