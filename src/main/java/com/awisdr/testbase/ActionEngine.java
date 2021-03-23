package com.awisdr.testbase;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.awisdr.utils.Constants;

public class ActionEngine extends PageInitializer {

	/**
	 * Method that click on Web element
	 * 
	 * @param element
	 */
	public static void click(WebElement element, String elementName) {
		try {
			waitForElementVisibile(element);
			element.click();
			test.log(Status.PASS, "Successfully clicked on " + elementName);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed clicked on " + elementName);
			test.log(Status.FAIL, "Exception :" + e.getMessage());
		}

	}

	public static int getSize(List<WebElement> element) {
		return element.size();
	}

	/**
	 * Method that sends text to any given element
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text, String elementName) {
		try {
			waitForPageToLoad(1000);
			waitForElementVisibile(element);
			element.clear();
			element.sendKeys(text);
			test.log(Status.PASS, "Successfully Entered " + text + " in " + elementName + " TextBox");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to enter data in " + elementName);
			test.log(Status.FAIL, "Exception :" + e.getMessage());
		}

	}

	public static void sendText(WebElement element, String text) {
		try {
			waitForPageToLoad(1000);
			waitForElementVisibile(element);
			element.clear();
			element.sendKeys(text);
		} catch (Exception e) {
			test.log(Status.FAIL, "Exception :" + e.getMessage());
		}

	}

	public static void sendKeys(WebElement element, Keys text, String keyName) {

		try {
			waitForElementVisibile(element);
			element.clear();
			element.sendKeys(text);
			test.log(Status.PASS, "Successfully Entered " + text + " in " + keyName + " TextBox");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to enter data in " + keyName);
			test.log(Status.FAIL, "Exception :" + e.getMessage());
		}
	}

	public static void waitForElementVisibile(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.visibilityOf(ele));

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
	public static void jsClick(WebElement element, String elementName) {
		try {
			waitForElementVisibile(element);
			getJSExecutor().executeScript("arguments[0].click();", element);
			test.log(Status.PASS, "Successfully clicked on " + elementName);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed clicked on " + elementName);
			test.log(Status.FAIL, "Exception :" + e.getMessage());
		}

	}

	public static void sendTextUsingJS(WebElement element, String text, String elementName) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value='" + text + "';", element);
			test.log(Status.PASS, "Successfully Entered " + text + " in " + elementName + " TextBox");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to enter data in " + elementName);
			test.log(Status.FAIL, "Exception :" + e.getMessage());
		}
	}

	public static void SendTextUsingJSInnerText(WebElement element, String text, String elementName) {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].innerHTML='" + text + "';", element);
			test.log(Status.PASS, "Successfully Entered " + text + " in " + elementName + " TextBox");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to enter data in " + elementName);
			test.log(Status.FAIL, "Exception :" + e.getMessage());
		}

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

	/**
	 * Method that will take a screenshot and store with name in specified location
	 * with .png extension
	 * 
	 * @param fileName
	 */
	public static void takeScreenshot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void waitForPageToLoad(int timeInMilliSeconds) {
		try {
			Thread.sleep(timeInMilliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method will generate timeStamp
	 * 
	 * @return
	 */
	public static String getTimeStamp() {

		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");

		return sdf.format(date);
	}

	public static void waitForInvisibilityOfElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}

	public static void WaitFor(int timeInMilliSeconds) {
		try {
			Thread.sleep(timeInMilliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void pasteDataUsingRobot(String textToCopy) {

//		String text = "Hello World";
		WaitFor(5000);
		StringSelection stringSelection = new StringSelection(textToCopy);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {
			// TODO: handle exception
		}
		WaitFor(5000);

	}

	public static String getText(WebElement element, String elementName) {
		String gettxt = "";
		try {
			waitForPageToLoad(1000);
			waitForElementVisibile(element);
			gettxt = element.getText();
			test.log(Status.PASS, "Get Text is successful from " + elementName + " And Value is: " + gettxt);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to get text from" + elementName);
			test.log(Status.FAIL, "Exception :" + e.getMessage());
		}
		return gettxt;
	}

	public static void selectDropdownUsingVisisbleText(WebElement element, String text, String elementName) {
		try {
			waitForPageToLoad(1000);
			waitForElementVisibile(element);
			Select select = new Select(element);
			select.selectByVisibleText(text);
			test.log(Status.PASS, "Successfully Selected " + text + " from the " + elementName + " Dropdown");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to  Select " + text + " from the " + elementName + " Dropdown");
			test.log(Status.FAIL, "Exception :" + e.getMessage());
		}

	}
	/*
	 * p boolean isElementPresent(By by) { try { driver.findElement(by); return
	 * true; } catch (NoSuchElementException e) { return false; }
	 */

	public static void isDisplayed(WebElement element, String elementName) {
		try {
			waitForPageToLoad(1000);
			element.isDisplayed();
			test.log(Status.PASS, "Successfully Displayed " + elementName);
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to  Display " + elementName);
			test.log(Status.FAIL, "Exception :" + e.getMessage());
		}

	}

	public void switchToLatestWindow(String parentWindowName) {
		Set<String> windowNames = driver.getWindowHandles();
		for (String string : windowNames) {
			if (!string.equalsIgnoreCase(parentWindowName)) {
				driver.switchTo().window(string);
			}
		}
	}
}
