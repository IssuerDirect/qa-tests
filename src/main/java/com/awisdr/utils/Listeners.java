package com.awisdr.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.awisdr.testbase.ActionEngine;

public class Listeners implements ITestListener {

	public void onTestSuccess(ITestResult result) {
		ActionEngine.takeScreenshot("passed/"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		ActionEngine.takeScreenshot("failed/"+result.getName());
	}
}
