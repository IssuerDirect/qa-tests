package com.awisdr.testcases;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.awisdr.testbase.ActionEngine;
import com.awisdr.utils.ConfigsReader;

public class VerifyPressReleaseCreationFunctionality extends ActionEngine {

	@Test(groups = { "smoke", "VerifyPressReleaseCreationFunctionality" })
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

}
