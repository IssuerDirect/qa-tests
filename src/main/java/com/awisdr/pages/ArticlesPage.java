package com.awisdr.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.awisdr.testbase.ActionEngine;

public class ArticlesPage extends ActionEngine {

	@FindBy(xpath = "//li[contains(text(),'Press Releases')]")
	WebElement pressReleases;
	@FindBy(xpath = "//a[contains(text(),'All PRs')]")
	WebElement allPRs;
	@FindBy(xpath = "//input[@placeholder='keyword search']")
	WebElement keywordSearch;
	@FindBy(xpath = "//input[@value='Find']")
	WebElement findBtn;
	@FindBy(xpath = "//tr[@class='gridheader']/th")
	List<WebElement> tableHeaders;
	@FindBy(xpath = "//a[text()='View']")
	WebElement view;
	@FindBy(id = "articleHeading")
	WebElement articleTitle;

	public ArticlesPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickPressRelease() {
		click(pressReleases, "Press Releases");
	}

	public void clickAllPrs() {
		click(allPRs, "All PRs");
	}

	public void searchKeyword(String keywordName) {
		sendText(keywordSearch, keywordName, "Keyword Search");
		click(findBtn, "Find Button");
	}

	public void clicViewButton() {
		click(view, "View Button");
	}

	public String getArticleTitle() {
		return getText(articleTitle, "Article Title");
	}

	public void verifyTableHeader(String headerName) {
		int position = 0;
		waitForPageToLoad(3000);
		ArrayList<String> listOfHeaders = new ArrayList<String>();
		for (WebElement webElement : tableHeaders) {
			String text = webElement.getText();
			if (text.isEmpty())
				text = "-";
			listOfHeaders.add(text);
		}

		for (int i = 1; i <= listOfHeaders.size(); i++) {
			if (listOfHeaders.get(i).equalsIgnoreCase(headerName))
				;
			{
//				listOfHeaders.indexOf(i);
				position = listOfHeaders.indexOf(headerName) + 1;
				break;
			}

		}
		waitForPageToLoad(3000);
		String headerValueTxt = "//tr[@class='gridrow']/td[" + position + "]";

		if (driver.findElements(By.xpath(headerValueTxt)).size() > 0) {
			String headerValue = driver.findElement(By.xpath("//tr[@class='gridrow']/td[" + position + "]")).getText();
			test.log(Status.PASS, "Verified " + "Header : " + headerName + ", Value is :" + headerValue);
			System.out.println("Header : " + headerName + " Value is :"
					+ driver.findElement(By.xpath("//tr[@class='gridrow']/td[" + position + "]")).getText());
		} else {
			test.log(Status.PASS, "Verified " + "Header : " + headerName + ", Value is :" + "-");
		}

//		driver.findElement(By.xpath("//tr[@class='gridrow']/td[" + position + "]")).getText();

	}

}
