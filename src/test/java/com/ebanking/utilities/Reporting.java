package com.ebanking.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.banking.testCases.BaseClass;

public class Reporting extends ReportUtility implements ITestListener {


	public void onTestStart(ITestResult result) {
		
		
		getMyReport();
		
		

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		BaseClass base = new BaseClass();
		String screenshotPath = System.getProperty("user.dir") + "//screenshots//" + result.getName()+".png";
		test.addScreenCaptureFromPath(screenshotPath);
		base.getShot(screenshotPath);
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir") + "//screenshots//" + result.getName()+".png";

		BaseClass base = new BaseClass();
		base.getShot(screenshotPath);

	}

	public void onTestSkipped(ITestResult result) {
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		

	}

	public void onStart(ITestContext context) {
		

	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
	
}
