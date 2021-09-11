package com.awisdr.utils;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
public class Constants {

	public static final String CONFIGURATION_FILEPATH=System.getProperty("user.dir")+"/src/main/resources/configs/configuration.properties";
	
	public static final String TESTDATA_FILEPATH=System.getProperty("user.dir")+"/TestData/InputTestData.xlsx";
	
	//public static final String CHROMEDRIVER_PATH=System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
	public static final String CHROMEDRIVER_PATH=System.getProperty("user.dir")+"\\NewDrivers\\chromedriver.exe";
	
	
	public static final String GECKODRIVER_PATH=System.getProperty("user.dir")+"/Drivers/geckodriver";
	
	public static final String EDGEDRIVER_PATH=System.getProperty("user.dir")+"/Drivers/edgedriver";
	
	public static final int IMPLICIT_WAIT_TIME=180;
	
	public static final int EXPLICIT_WAIT_TIME=60;
	
	public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"/target/screenshots/";
	
	public static final String IMAGE_FILEPATH=System.getProperty("user.dir") + "\\TestData\\icon_2.png";
	public static final String INPUTDATA_FILEPATH=System.getProperty("user.dir") + "\\TestData\\InputTextFile.txt";
	
	public static final int HIGHVAL = 5000;
	public static final int MEDVAL = 3000;
	public static final int LOWVAL = 1000;
	public static final SoftAssert softAssert = new SoftAssert();
	public static Boolean bStatus=false;
	public static final String strPath = "src//test//resources//IP_OR_Original.xlsx";
	public static final String strTabNameBAM = "BAM";

	public static WebDriver driver;
	
}
