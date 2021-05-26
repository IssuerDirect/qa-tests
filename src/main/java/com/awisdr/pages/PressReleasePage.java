package com.awisdr.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import javax.imageio.stream.FileCacheImageOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.awisdr.testbase.ActionEngine;
import com.awisdr.utils.Constants;
import com.awisdr.utils.TextUtils;
import com.awisdr.utils.TextUtils.Mode;
import com.mongodb.client.model.ReturnDocument;

public class PressReleasePage extends ActionEngine {

	@FindBy(xpath = "//a[@class='btn btn-primary rounded-pill no-wrap mt-2 pl-4 pr-4 mr-sm-2 mr-0']")
	WebElement createPreassRelease;

	@FindBy(xpath = "//button[@class='btn btn-primary rounded-pill']")
	WebElement continueWithCollaboration;

	@FindBy(xpath = "//*[@id=\"build\"]/app-editor/div/div[2]/div/div/input")
	WebElement headLine;

	@FindBy(xpath = "//span[text()='Insert image']//ancestor::button")
	WebElement insertImage;
	@FindBy(xpath = "//span[text()='Insert table']//ancestor::button")
	WebElement insertTable;
	@FindBy(xpath = "//span[text()='Insert table']//ancestor::button//following-sibling::div//div[@data-row='3' and @data-column='3']")
	WebElement numberOfColumns;
	@FindBy(xpath = "(//div[@class=\"ck ck-widget__selection-handle\"]//following-sibling::table//td[contains(@class,'ck-editor__editable')]/span)[1]")
	WebElement firstRow;
	@FindBy(xpath = "(//div[@class=\"ck ck-widget__selection-handle\"]//following-sibling::table//td[contains(@class,'ck-editor__editable')]/span)[2]")
	WebElement secondRow;
	@FindBy(xpath = "(//div[@class=\"ck ck-widget__selection-handle\"]//following-sibling::table//td[contains(@class,'ck-editor__editable')]/span)[3]")
	WebElement thirdRow;
	@FindBy(xpath = "(//div[@class=\"ck ck-widget__selection-handle\"]//following-sibling::table//td[contains(@class,'ck-editor__editable')]/span)[4]")
	WebElement fourthRow;
	@FindBy(xpath = "(//div[@class=\"ck ck-widget__selection-handle\"]//following-sibling::table//td[contains(@class,'ck-editor__editable')]/span)[5]")
	WebElement fifthRow;
	@FindBy(xpath = "(//div[@class=\"ck ck-widget__selection-handle\"]//following-sibling::table//td[contains(@class,'ck-editor__editable')]/span)[6]")
	WebElement sixthRow;
	@FindBy(xpath = "(//div[@class=\"ck ck-widget__selection-handle\"]//following-sibling::table//td[contains(@class,'ck-editor__editable')]/span)[7]")
	WebElement seventhRow;
	@FindBy(xpath = "(//div[@class=\"ck ck-widget__selection-handle\"]//following-sibling::table//td[contains(@class,'ck-editor__editable')]/span)[8]")
	WebElement eightthRow;
	@FindBy(xpath = "(//div[@class=\"ck ck-widget__selection-handle\"]//following-sibling::table//td[contains(@class,'ck-editor__editable')]/span)[9]")
	WebElement ninethRow;

	@FindBy(xpath = "//*[@id=\"build\"]/app-editor/div/div[3]/div/div[1]/div[2]/ckeditor/div[2]/div[2]/div[2]")
	WebElement releaseBody;
	@FindBy(xpath = "//button[text()='Next']//preceding-sibling::button[text()='Save as Draft']")
	WebElement saveDraft;
	@FindBy(xpath = "//img[contains(@src,'draft_white.png')]//parent::a")
	WebElement draftsInWork;
	@FindBy(xpath = "/html/body/app-root/app-dashboard-layout/div/div[2]/div[2]/app-dashboard/div[2]/div/div[3]/div/div[1]/a")
	WebElement saveDraftfile;
	@FindBy(xpath = "/html/body/app-root/app-dashboard-layout/div/div[2]/div[2]/app-releases-view/div/div[1]/div/button")
	WebElement edit;
	@FindBy(xpath = "//*[@id=\"build\"]/app-editor/div/div[3]/div/div/div[2]/ckeditor/div[2]/div[2]/div[1]/div/button[8]/svg")
	WebElement align;
	@FindBy(xpath = "//span[text()='Insert media']//ancestor::button")
	WebElement videolnk;
	@FindBy(xpath = "//label[text()='Media URL']//preceding-sibling::input")
	WebElement vlinkbox;
	@FindBy(xpath = "//label[text()='Media URL']//preceding-sibling::input//ancestor::div[contains(@class,'ck ck-labeled-field-view')]//following-sibling::button[@type='submit']")
	WebElement videoLinkSubmitBtn;
	@FindBy(xpath = "//*[@id=\"build\"]/app-editor/div/div[3]/div/div/div[2]/ckeditor/div[2]/div[2]/div[2]/figure/div[1]/div[2]/svg")
	WebElement imgentr;
	@FindBy(xpath = "//button[@class='ck ck-button ck-off ck-button-save']")
	WebElement svvlnk;
	@FindBy(xpath = "//div[@class='ck ck-labeled-field-view ck-labeled-field-view_empty']")
	WebElement vtxtb;
	@FindBy(xpath = "//button[@class='btn btn-outline-warning rounded-pill pl-sm-5 pr-sm-5 pl-4 pr-4 ml-3']")
	WebElement nextbtn;
	@FindBy(xpath = "//button[text()='Schedule Date']")
	WebElement scheduledate;
	@FindBy(xpath = "//input[@formcontrolname='adate']")
	WebElement enterdate;
	@FindBy(xpath = "//*[@id=\"build\"]/app-editor/div/div[3]/div/div/div[2]/ckeditor/div[2]/div[2]/div[1]/div/button[10]]")
	WebElement fullscrn;
	@FindBy(xpath = "//i[@class='far fa-calendar-alt text-primary text-size-23p']")
	WebElement calenderIcon;
	@FindBy(xpath = "//select[@formcontrolname='topics']")
	WebElement drpdwnPressReleaseType;
	@FindBy(xpath = "//button[@class='btn btn-outline-warning rounded-pill pl-sm-5 pr-sm-5 pl-4 pr-4 ml-3']//parent::button")
	WebElement nextbuttonsecondpage;
	@FindBy(xpath = "//*[@id=\"addon\"]/app-addon/div/div[2]/div/div[1]/button")
	WebElement mediaTargeting;
	@FindBy(xpath = "//button[@class='btn btn-outline-warning rounded-pill pl-sm-5 pr-sm-5 pl-4 pr-4 ml-3']")
	WebElement nextbuttonThirdPage;
	@FindBy(xpath = "//label[@for='agreement' and @class='ml-3']")
	WebElement agreebtn;
	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-warning rounded-pill mt-3 w-100']")
	WebElement submitToEditorialbtn;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phnTextBox;
	@FindBy(xpath = "//*[@type='button' and @class='btn btn-warning rounded-pill text-nowrap pl-sm-3 pr-sm-3']")
	WebElement submitWithCollaboration;
	
	
	
	
	
	public PressReleasePage() {
		PageFactory.initElements(driver, this);
	}

	public void clickPressRelease() {
		waitForClickability(createPreassRelease);
		click(createPreassRelease, "Press Releases");
	}

	public void clickcontinueWithCollaboration() {
		waitForClickability(continueWithCollaboration);
		click(continueWithCollaboration, "Press Releases");
	}

	public void enterHeadLine() {
		sendText(headLine, "testSreeAutomation");
	}

	public void insertImage() throws AWTException {
		click(insertImage, "InsertImaGE");

//		Robot robot = new Robot();
//		StringSelection selecttext = new StringSelection(Constants.IMAGE_FILEPATH);
//
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selecttext, null);
//
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.delay(1500);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		pasteDataUsingRobotAndEnter(Constants.IMAGE_FILEPATH);
	}

	public void uploadFileWithRobot() throws InterruptedException {
		WaitFor(1000);
		click(insertImage, "Press Releases");
		StringSelection stringSelection = new StringSelection(
				"C:\\Users\\Chinni\\AccessWireISDRGit\\AccessWireISDRGit\\qa-tests\\src\\main\\resources\\icon 2.png");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		/*
		 * robot.keyRelease(KeyEvent.VK_ENTER); robot.delay(150);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 */

	}

	public void getTextFromTextFile() throws IOException {
		FileReader fr = null;
		BufferedReader txtReader = null;
		String sCurrentLine = null;
		try {
			fr = new FileReader(Constants.INPUTDATA_FILEPATH);
			txtReader = new BufferedReader(fr);
			while ((sCurrentLine = txtReader.readLine()) != null) {
				driver.findElement(By.xpath(
						"//*[@id=\"build\"]/app-editor/div/div[3]/div/div[1]/div[2]/ckeditor/div[2]/div[2]/div[2]"))
						.sendKeys(sCurrentLine);
				enterUsingRobot();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (txtReader != null)
					txtReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

	public void enterTextInField() {
		// String b= (getTextFromTextFile());
		releaseBody.click();
		releaseBody.sendKeys(
				"DEMO COMPANY® REPORTS FOURTH QUARTER AND FISCAL YEAR 2018 FINANCIAL PERFORMANCE Fourth Quarter 2018: Revenues $5.5 Million; Net Loss ($3.1 Million); Adjusted EBITDA $1.1 Million Fiscal Year 2018: Revenues $22.4 Million; Net Loss ($5.9 Million); Adjusted EBITDA $2.9 Million; Cash from Operations $1.4 Million  Atlanta, GA – April 22, 2019 – DEMO COMPANY Solutions, Inc. (NASDAQ: STRM), provider of integrated solutions, technology-enabled services and analytics supporting revenue cycle optimization for healthcare enterprises, today announced financial results for the fourth quarter and fiscal year2018, which ended January  31, 2019.");
		saveDraft.click();
		WaitFor(2500);

	}

	public void selectDraftsInWorks() throws InterruptedException {
		WaitFor(2000);
		click(draftsInWork, "Save Draft");
		click(saveDraftfile, "Save Draft Link");
		click(edit, "Edit Link");
	}

	public void tableReader() {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Chinni\\AccessWireISDRGit\\AccessWireISDRGit\\qa-tests\\src\\main\\resources\\test.docx");
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			Iterator<IBodyElement> bodyElementIterator = xdoc.getBodyElementsIterator();
			while (bodyElementIterator.hasNext()) {
				IBodyElement element = bodyElementIterator.next();

				if ("TABLE".equalsIgnoreCase(element.getElementType().name())) {
					List<XWPFTable> tableList = element.getBody().getTables();
					for (XWPFTable table : tableList) {
						System.out.println("Total Number of Rows of Table:" + table.getNumberOfRows());
						for (int i = 0; i < table.getRows().size(); i++) {

							for (int j = 0; j < table.getRow(i).getTableCells().size(); j++) {
								System.out.println(table.getRow(i).getCell(j).getText());
								waitForClickability(releaseBody);
								WaitFor(2000);
								releaseBody.sendKeys(table.getRow(i).getCell(j).getText());
							}
						}
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void retable() {
		waitForClickability(releaseBody);
		// driver.findElement(By.xpath("//*[@id=\"build\"]/app-editor/div/div[3]/div/div[1]/div[2]/ckeditor/div[2]/div[2]/div[2]")).sendKeys(tableReader());
	}

	public void createTable() throws FileNotFoundException, IOException {

		try (XWPFDocument doc = new XWPFDocument()) {

			XWPFTable table = doc.createTable();

			// Creating first Row
			XWPFTableRow row1 = table.getRow(0);
			row1.getCell(0).setText("First Row, First Column");
			row1.addNewTableCell().setText("First Row, Second Column");
			row1.addNewTableCell().setText("First Row, Third Column");

			// Creating second Row
			XWPFTableRow row2 = table.createRow();
			row2.getCell(0).setText("Second Row, First Column");
			row2.getCell(1).setText("Second Row, Second Column");
			row2.getCell(2).setText("Second Row, Third Column");

			// create third row
			XWPFTableRow row3 = table.createRow();
			row3.getCell(0).setText("Third Row, First Column");
			row3.getCell(1).setText("Third Row, Second Column");
			row3.getCell(2).setText("Third Row, Third Column");

			// save to .docx file
			try (FileOutputStream out = new FileOutputStream("c:\\test\\table.png")) {
				doc.write(out);

			}

		}

	}

	public void saveAsDraft() {
//		saveDraft.click();
		WaitFor(10);
		WaitFor(10);
		jsClick(saveDraft, "SaveDraft");

	}
	public void fullScrnClick() {
		WaitFor(2000);
		jsClick(fullscrn, "FullscreenMode");

	}

	public void enterNext() {
		//nextbtn.click();
		jsClick(nextbtn, "nextbtn");

	}

	public void enterspace() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ENTER);

	}

	public void alignn() throws InterruptedException {
		Actions actionObj = new Actions(driver);
		actionObj.keyDown(Keys.CONTROL).sendKeys(Keys.chord("A")).keyUp(Keys.CONTROL).perform();
		WaitFor(10);
		align.click();
		WaitFor(10);
	}

	public void uploadVideoLink() {
		// imgentr.click();
		WaitFor(2000);
		click(videolnk, "youtube video link");
		sendText(vlinkbox, "https://www.youtube.com/watch?v=LFDrDnKPOTg&ab_channel=Simplilearn");
		WaitFor(200);
		jsClick(videoLinkSubmitBtn, "Submit button");
		enterUsingRobot();

	}

	public void enterUsingRobot() {
		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		     robot.delay(250);

	}

	public void uploadFileWithRobot1() throws AWTException, InterruptedException {
		WaitFor(2000);
		jsClick(insertImage, "InsertImage");
		WaitFor(2000);
		StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\TestData\\icon_2.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
//		     robot.delay(250);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);
		WaitFor(2000);

		enterUsingRobot();
	}

	public void insertTable() {
		WaitFor(2000);
		jsClick(insertTable, "Insert Table1");
		jsClick(numberOfColumns, "Number of columns");
		WaitFor(2000);
		SendTextUsingJSInnerText(firstRow, TextUtils.generateRandomString(5, Mode.ALPHANUMARIC), "First Row");
		SendTextUsingJSInnerText(secondRow,TextUtils.generateRandomString(5, Mode.ALPHANUMARIC), "Second Row");
		/*
		 * SendTextUsingJSInnerText(thirdRow, TextUtils.generateRandomString(5,
		 * Mode.ALPHANUMARIC), "Third Row"); SendTextUsingJSInnerText(fourthRow,
		 * TextUtils.generateRandomString(5, Mode.ALPHANUMARIC), "fourth Row");
		 * SendTextUsingJSInnerText(fifthRow, TextUtils.generateRandomString(5,
		 * Mode.ALPHANUMARIC), "Fifth Row"); SendTextUsingJSInnerText(sixthRow,
		 * TextUtils.generateRandomString(5, Mode.ALPHANUMARIC), "6th Row");
		 */
//		SendTextUsingJSInnerText(seventhRow, TextUtils.generateRandomString(5, Mode.ALPHANUMARIC), "7th Row");
//		SendTextUsingJSInnerText(eightthRow, TextUtils.generateRandomString(5, Mode.ALPHANUMARIC), "8th Row");
//		SendTextUsingJSInnerText(ninethRow,TextUtils.generateRandomString(5, Mode.ALPHANUMARIC), "9th Row");
	}
	
	

public void selectdate() {
	Calendar calendar = Calendar.getInstance();
	Date today = calendar.getTime();

	calendar.add(Calendar.DAY_OF_YEAR, 1);
	Date tomorrow = calendar.getTime();
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	String todayAsString = dateFormat.format(today);
	String tomorrowAsString = dateFormat.format(tomorrow);
	System.out.println(tomorrowAsString);
	WaitFor(1500);
	calenderIcon.click();
	WaitFor(2500);
	scheduledate.click();
	enterdate.clear();
	WaitFor(2500);
	enterdate.sendKeys(tomorrowAsString);
	WaitFor(2500);
}
		public void pressRelaeseTypeDrpdwn() {
			selectDropdownUsingVisisbleText(drpdwnPressReleaseType, "Company Name Change", "PressReleaeDrpdwn");
		}

		public void nextpagesecond() {
			scrollDown(20);
			nextbuttonsecondpage.click();
		}
		public void clickOnMediaTargeting() {
			WaitFor(2000);
			mediaTargeting.click();
		}
		public void nextpageThird() {
			scrollDown(20);
			jsClick(nextbuttonThirdPage, "Next button");
		}
		
		public void finalStepOnSubmit() {
		jsClick(agreebtn, "Agree button");
		scrollDown(10);
		phnTextBox.clear();
		sendText(phnTextBox, "3179791211", "phonenumber");
		waitForClickability(submitToEditorialbtn);
		jsClick(submitToEditorialbtn, "Submit to editorial team button");
		waitForClickability(submitWithCollaboration);
		jsClick(submitWithCollaboration, "submitWithCollaboration");
		
		
		}
	}


