package com.awisdr.testcases;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.awisdr.testbase.ActionEngine;
import com.awisdr.testbase.TestEngine;
import com.awisdr.utils.ConfigsReader;
import com.codoid.products.exception.FilloException;

public class VerifyBrandAssetsManagerFunctionality extends ActionEngine {
	@Test(groups = { "smoke", "VerifyBrandAssetsManagerFunctionality" })
	public void verifyBrandAssetsManagerFunctionality()
			throws AWTException, InterruptedException, FileNotFoundException, IOException, FilloException {

		
		  login.validateClientLoginScreen();
		 login.loginToClientApplication(ConfigsReader.getPropValue("clientUsername"),
		  ConfigsReader.getPropValue("clientPassword"));
		 brandAssetsManagerPage.setUploadDocumentData();
		 login.applicationLogoutLink();
}
}

