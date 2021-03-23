package com.awisdr.testcases;

import org.testng.annotations.Test;

import com.awisdr.testbase.ActionEngine;
import com.awisdr.utils.ConfigsReader;

public class VerifyClientApplicationLoginFunctionality extends ActionEngine {

	@Test(groups = { "smoke", "verifyClientApplicationLoginFunctionality" })
	public void verifyClientApplicationLoginFunctionality() {
		login.validateClientLoginScreen();
		login.loginToClientApplication(ConfigsReader.getPropValue("clientUsername"), ConfigsReader.getPropValue("clientPassword"));
		login.verifyApplicationLogoutLink();
	}

}
