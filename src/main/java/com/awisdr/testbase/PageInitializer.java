package com.awisdr.testbase;

import com.awisdr.pages.ArticlesPage;
import com.awisdr.pages.BrandAssetsManagerPage;
import com.awisdr.pages.LoginPage;
import com.awisdr.pages.PressReleasePage;

public class PageInitializer extends TestEngine {

	public static LoginPage login;
	public static ArticlesPage articlesPage;
	public static PressReleasePage pressReleasePage;
	public static BrandAssetsManagerPage brandAssetsManagerPage;
	public static void initializePageObjects() {
		login = new LoginPage();
		articlesPage = new ArticlesPage();
		pressReleasePage = new PressReleasePage();
		brandAssetsManagerPage = new BrandAssetsManagerPage(driver);

	}
}
