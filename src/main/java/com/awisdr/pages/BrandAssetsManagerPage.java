package com.awisdr.pages;

import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awisdr.testbase.ActionEngine;
import com.awisdr.utils.CommonMethods;
import com.awisdr.utils.Constants;
import com.codoid.products.exception.FilloException;

public class BrandAssetsManagerPage extends ActionEngine {

	public BrandAssetsManagerPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	CommonMethods cmnMethods = new CommonMethods(driver);
	@FindBy(xpath = "//ul[@class='w-list-unstyled']/li[5]")
	WebElement brandAssetsManagerLnk;
	@FindBy(xpath = "//button[@class='btn upload-button mr-2']")
	WebElement uploadFileBtn;
	@FindBy(xpath = "//div[@class='inner-container py-5']")
	WebElement fileToUploadlnk;
	@FindBy(xpath = "//select[@formcontrolname='fileCategory']")
	WebElement categoryDropdown;
	@FindBy(xpath = "//button[text()=' Upload Files ']")
	WebElement uploadFiles;
	@FindBy(xpath = "//i[@title='Edit']")
	WebElement editFile;
	@FindBy(xpath = "//button[@class='btn edit-remove-button']")
	WebElement removeFile;
	@FindBy(xpath = "//button[contains(text(),' Remove ')]")
	WebElement removeBtn;
	
	/*
	 * @Author: SreeGuntaka 
	 * Feature : Brand Assets Manager
	 * @Description: This method sets data in BAM upload window Ex:
	 * setUploadDocumentData(String strTabName, String strFilePath, String
	 * strSheetName, ObjectRepositoryTestData objRepTestData)
	 */
	@SuppressWarnings("static-access")
	public void setUploadDocumentData() throws IOException, FilloException {
		try {
			Thread.sleep(Constants.HIGHVAL);
			Thread.sleep(Constants.HIGHVAL);
			waitForClickability(brandAssetsManagerLnk);
			click(brandAssetsManagerLnk, "BAMLnk");
			WaitFor(2000);
			Thread.sleep(Constants.HIGHVAL);
			waitForClickability(uploadFileBtn);
			click(uploadFileBtn, "Upload File Button");
			Thread.sleep(Constants.HIGHVAL);
			click(fileToUploadlnk, "File To Upload");
			StringSelection str = new StringSelection(
					System.getProperty("user.dir") + "\\src\\main\\resources\\TestDOCX.docx");
			cmnMethods.setBrowseData(str);
			Thread.sleep(Constants.MEDVAL);
			click(categoryDropdown, "uploadedFiles");
			Thread.sleep(Constants.MEDVAL);
			categoryTypeDrpdwn();
			Thread.sleep(Constants.MEDVAL);
			waitForClickability(uploadFiles);
			click(uploadFiles, "uploadedFiles");
			Thread.sleep(Constants.MEDVAL);
			waitForClickability(editFile);
			click(editFile, "editUploadedFile");
			Thread.sleep(Constants.MEDVAL);
			waitForClickability(removeFile);
			click(removeFile, "removeUploadedFile");
			Thread.sleep(Constants.MEDVAL);
			waitForClickability(removeBtn);
			click(removeBtn, "removeUploadedFile");
			Thread.sleep(Constants.HIGHVAL);
			System.out.println("In Upload dcoument module file has been set and clicked on upload button");

		} catch (Exception e) {
			System.out.println("Exception occured in setUploadDocumentData method due to : " + e.toString());
		}
	}

	public void categoryTypeDrpdwn() {
		selectDropdownUsingVisisbleText(categoryDropdown, "Other", "categoryDropdownField");
	}

	


}
