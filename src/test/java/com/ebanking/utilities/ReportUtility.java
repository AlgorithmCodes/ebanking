package com.ebanking.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtility {
	
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public ExtentReports getMyReport() {
		if(extent==null) {
			extent=new ExtentReports();
		}
		else {
			return extent;
		}
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "test-report" + timestamp + ".html";
		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\" + repName);
		extent.attachReporter(reporter);
		extent.setSystemInfo("Env", "QA");
		reporter.config().setDocumentTitle("automation result");
		
		return extent;
		
		
	}
}
