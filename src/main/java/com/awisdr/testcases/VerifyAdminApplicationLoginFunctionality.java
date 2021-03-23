package com.awisdr.testcases;

import org.testng.annotations.Test;

import com.awisdr.testbase.ActionEngine;
import com.awisdr.utils.ConfigsReader;

public class VerifyAdminApplicationLoginFunctionality extends ActionEngine {

	@Test(groups = { "smoke", "verifyAdminApplicationLoginFunctionality" })
	public void verifyAdminApplicationLoginFunctionality() {
		login.verifyAdminLoginPage();
		login.loginToAdminApplication(ConfigsReader.getPropValue("adminEmail"),
				ConfigsReader.getPropValue("adminPassword"));
		articlesPage.clickPressRelease();
		articlesPage.clickAllPrs();
		articlesPage.searchKeyword("632517");
		articlesPage.verifyTableHeader("ID");
		articlesPage.verifyTableHeader("Company");
		articlesPage.verifyTableHeader("Sub Account");
		articlesPage.verifyTableHeader("Title");
		articlesPage.verifyTableHeader("Options");
		articlesPage.verifyTableHeader("Assigned To");
		articlesPage.verifyTableHeader("Status");
		articlesPage.verifyTableHeader("Date");
		String parentWindowName = driver.getWindowHandle();
		articlesPage.clicViewButton();
		switchToLatestWindow(parentWindowName);
		articlesPage.getArticleTitle();
	}

}
