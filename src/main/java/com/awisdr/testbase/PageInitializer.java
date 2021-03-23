package com.awisdr.testbase;

import com.awisdr.pages.ArticlesPage;
import com.awisdr.pages.LoginPage;

public class PageInitializer extends TestEngine {

	public static LoginPage login;
	public static ArticlesPage articlesPage;

	public static void initializePageObjects() {
		login = new LoginPage();
		articlesPage = new ArticlesPage();

	}
}
