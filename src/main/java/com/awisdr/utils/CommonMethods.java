package com.awisdr.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.awisdr.testbase.BaseClass;
import com.awisdr.testbase.PageInitializer;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.awisdr.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.codoid.products.exception.FilloException;

public class CommonMethods extends PageInitializer {
	FindElements sDataRead = new FindElements(driver);
	 public static WebDriver driver = null;
	  public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	  public CommonMethods(WebDriver driver) {
	    this.driver = driver;
	  }
	/**
	 * Method that sends text to any given element
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method return Object of JavaScript Executor type
	 * 
	 * @return js object
	 */
	public static JavascriptExecutor getJSExecutor() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * Method performs click using JavaScript executor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSExecutor().executeScript("arguments[0].click();", element);
	}

	/**
	 * Methods scrolls up using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0, -" + pixel + ")");
	}

	/**
	 * Methods scrolls down using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSExecutor().executeScript("window.scrollBy(0," + pixel + ")");
	}

	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
	}

	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * Method that will take a screenshot and store with name in specified location with .png extension
	 * @param fileName
	 */
	public static void takeScreenshot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(Constants.SCREENSHOT_FILEPATH + fileName +getTimeStamp()+ ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will generate timeStamp
	 * @return
	 */
	public static String getTimeStamp() {
		
		Date date=new Date();
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
		
		return sdf.format(date);
	}
	
	public void setBrowseData(StringSelection str) throws AWTException
	{
		Robot robot = new Robot();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        robot.delay(Constants.LOWVAL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(90);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

	public static String getSysDate()
	{
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		 
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy");  
		 
		//System.out.println(sdf.format(date));           //05-05-2020 12:01
		//System.out.println(sdf.format(cal.getTime()));
		return sdf.format(date);
	}
	
	/* @Author: SreeGuntaka
	 * Feature : generic   
	 * @Description: This method verifies buttons Active/Presence status
	   Ex: verifyButtonStatus(String strTabName, String strObjName, String strFilePath, String strSheetName) */
	public Boolean verifyButtonStatus(String strTabName, String strFilePath, String strSheetName, String objName) throws IOException, FilloException
	{
		Boolean bStatus = false;
		try{
			List<WebElement> object = sDataRead.getObjNewMethod(strTabName, objName, strFilePath, strSheetName);
			if(object.get(0).isDisplayed()==true)
			{
				bStatus= true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in verifyButtonStatus method due to : " + e.toString());
		}
		return bStatus;
	}
	
	/* @Author: SreeGuntaka
	 * Feature : Generic 
	 * @Description: This method handles alers which requires confirmation after clicking button/save/after submitting data in some windows
	   Ex: handleAlerts(String strTabName,String strObjectName,String strFilePath,String strSheetName) */
	public static Boolean handleAlerts(String strTabName,String strObjectName, String strFilePath,String strSheetName) throws IOException, FilloException, InterruptedException{
		Boolean bStatus = false;
		try{
			Thread.sleep(Constants.LOWVAL);
			List<WebElement> objGetObject = FindElements.getObjNewMethod(strTabName, strObjectName, strFilePath, strSheetName);
			if(objGetObject.get(0).isDisplayed()==true)
			{
				objGetObject.get(0).click();
				Thread.sleep(Constants.LOWVAL);
				bStatus=true;
			}
			else if(objGetObject.get(0)==null)
			{
				System.out.println("Alert is not present");
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Following exception got handleAlerts method: "+e.getMessage());
		}
		return bStatus;
	}
	
	
}
