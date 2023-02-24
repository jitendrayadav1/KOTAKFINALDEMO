//package com.kotak.utilities;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
//
//import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.ISuiteListener;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.Markup;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.kotak.Base.TestBase;
//
//public class An_ExtentReport  implements ITestListener, ISuiteListener {
//
//	public ExtentSparkReporter extentSparkReporter;
//	public ExtentReports extentReports;
//	public ExtentTest extentTest;
//
//	public void onStart(ITestContext testContext) {
//
//		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
//		String reportName = "Kotak netBanking" + timestamp + ".html";
//
//		extentSparkReporter=new ExtentSparkReporter(".//Reports//"+reportName);
//		extentSparkReporter.config().setDocumentTitle("Automation Report");
//		extentSparkReporter.config().setReportName("Kotak netBanking Testing Report");
//		extentSparkReporter.config().setTheme(Theme.DARK);
//		extentSparkReporter.config().setTimelineEnabled(true);
//
//		extentReports=new ExtentReports();
//		extentReports.attachReporter(extentSparkReporter);
//		//add system environment info to extent report,so it is common to all reporter
//
//		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
//		extentReports.setSystemInfo("Java Varsion", System.getProperty("java.version"));
//		extentReports.setSystemInfo("APP URL", "https://www.kotak.com/en/home.html");
//		extentReports.setSystemInfo("Environment", "QA");
//		extentReports.setSystemInfo("User", "Reshma Chachar");
//
//	}
//
//
//
//	public void onTestSuccess(ITestResult tr) {
//
//		extentTest=extentReports.createTest(tr.getName());//creating new entry
//		extentTest.log(Status.PASS,"Passed Test Case is "+tr.getName());//adding log details
//	}
//
//
//	public void onTestFailure(ITestResult tr) {
//
//		extentTest=extentReports.createTest(tr.getName());
//		extentTest.log(Status.FAIL,"Failed Test Case is "+tr.getName());
//		extentTest.log(Status.FAIL,"Test Case is Failed because "+tr.getThrowable().getStackTrace());
////		String excepionMessage=Arrays.toString(tr.getThrowable().getStackTrace());
////		extentTest.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
////				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
//		String screenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
//		
//		File screenShotFile = new File(screenShotPath);
//		if(screenShotFile.exists()) 
//		{ 
//			extentTest.fail("Captured Screenshot is below:" + extentTest.addScreenCaptureFromPath(screenShotPath)); 
//		}
//		else
//		{
//			try {
//				String filePath=TestBase.takesScreenshot(tr.getName());
//				extentTest.fail("Captured Screenshot :" + extentTest.addScreenCaptureFromPath(filePath));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//
//	}
////public void onTestFailure(ITestResult tr) {
////		
////
////	try {
////		String filePath=TestBase.takesScreenshot(tr.getName());
////		extentTest.fail("Captured Screenshot :" + extentTest.addScreenCaptureFromPath(filePath));
////	} catch (IOException e) {
////	// TODO Auto-generated catch block
////		e.printStackTrace();
////		}
////		String methodName=tr.getMethod().getMethodName();
////		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " FAILED"+"</b>";	
////		String excepionMessage=Arrays.toString(tr.getThrowable().getStackTrace());
////		extentTest.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
////				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
////	
////	
////
////		//extentTest.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(.fileName)
////				//.build());
////	
////		
////		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
////		extentTest.log(Status.FAIL, m);
////		
////		
////
////	}
////
//
//	public void onTestSkipped(ITestResult tr) {
//
//		extentTest=extentReports.createTest(tr.getName());
//		extentTest.log(Status.SKIP,"Skipped Test Case is "+tr.getName());
//
//	}
//
//	public void onFinish(ITestContext testContext) {
//		extentReports.flush();
//	}
//
//}
//
//
//
