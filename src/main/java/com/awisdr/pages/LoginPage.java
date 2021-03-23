package com.awisdr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.awisdr.testbase.ActionEngine;

public class LoginPage extends ActionEngine {

	@FindBy(xpath = "//img[@class='landing-logo cursor-pointer']")
	WebElement cmplogo;

	@FindBy(xpath = "//li[@class='menu-item']//a[contains(text(),'About')]")
	WebElement aboutlnk;

	@FindBy(xpath = "//li[@class='menu-item']//a[contains(text(),'Products')]")
	WebElement productlnk;

	@FindBy(xpath = "//li[@class='menu-item']//a[contains(text(),'Resources')]")
	WebElement resourceslnk;

	@FindBy(xpath = "//li[@class='menu-item']//a[contains(text(),'Newsroom')]")
	WebElement newslnk;

	@FindBy(xpath = "//a[contains(text(),'Tell My Story')]")
	WebElement tellmystry;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	WebElement clientUserNameTxtBx;

	@FindBy(xpath = "//input[@type='password']")
	WebElement clientPasswordTxtBx;

	@FindBy(xpath = "//div[@class='col-12']/button[contains(text(),'Login')]")
	WebElement clientLoginBtn;

	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logout;
	@FindBy(xpath = "//input[contains(@id,'_email')]")
	WebElement adminEmailTxtBx;
	@FindBy(xpath = "//input[contains(@id,'_password')]")
	WebElement adminPasswordTxtBx;
	@FindBy(xpath = "//button[@onclick='login()']")
	WebElement adminLoginButton;
	@FindBy(xpath = "//h4[contains(text(),'Administration Login')]")
	WebElement adminLoginPage;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void validateClientLoginScreen() {
		waitForPageToLoad(3000);
		isDisplayed(cmplogo, "Company Logo Link");
		isDisplayed(productlnk, "Product Link");
		isDisplayed(aboutlnk, "About Link");
		isDisplayed(resourceslnk, "Resources Link");
		isDisplayed(newslnk, "News Link");
		isDisplayed(tellmystry, "Tell My Story Link");
	}

	public void loginToClientApplication(String userNme, String pwd) {
		sendText(clientUserNameTxtBx, userNme);
		sendText(clientPasswordTxtBx, pwd);
		click(clientLoginBtn, "Login Button");
	}

	public void verifyApplicationLogoutLink() {
		isDisplayed(logout, "Logout Link");
	}

	public void verifyAdminLoginPage() {
		isDisplayed(adminLoginPage, "Administration Login'");
	}

	public void loginToAdminApplication(String userName, String password) {
		sendText(adminEmailTxtBx, userName);
		sendText(adminPasswordTxtBx, password);
		click(adminLoginButton, "Login Button");
	}
}
