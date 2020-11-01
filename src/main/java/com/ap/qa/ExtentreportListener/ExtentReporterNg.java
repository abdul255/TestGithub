package com.ap.qa.ExtentreportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNg  implements IReporter{
	
	private ExtentReports extent;
	
	
	//  list serch for xml file, outputdirectory will create seperate file
	// list of the class
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outPutDirectory) {
		
		extent=new ExtentReports(outPutDirectory + File.separator + "Extent.html", true);

		// you can run specific class as well- loop through then whatever you want execute
		// just need to create one xml file
		// map allow you to map to the specific method, it has to connect correct method
		
	for(ISuite suite : suites) {
		Map<String, ISuiteResult> result =suite.getResults();
		
		// isuit basically the suit name homepage or checkoutpage executed
		// isuiteresult allow you to capture the result of the execution of this specific suite
		//getTestcontext- if it fail - why did it fail = i will get the information
		
	for(ISuiteResult r : result.values()) {
		ITestContext context = r.getTestContext();
		
		//get the information for pass, fail, skipping
		
		buildTestNodes (context.getPassedTests(), LogStatus.PASS);
		buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
		buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
	}
	}
	//	flush=when you executed clearing the informatio than closing 
	extent.flush();
	extent.close();

}

	// reference the above information and maping it to class, method, basically maping information
	// if you dont have any methodd no reason to capture the informatoion it have to have at least one information
	 //test= get the method name when im getting the result, capture the method name 
	//test= getting the start time and end time
	
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;
		
		if(tests.size()>0) {
			for(ITestResult result : tests.getAllResults())	{
				
				test=extent.startTest(result.getMethod().getMethodName());
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				
				// im getting the result in group level
				// catagory= is it falling under passing, falling, skipping
				
				for(String group : result.getMethod().getGroups())
				test.assignCategory(group);
				
				// if the  exception during exccuting i wanna capture the exception
				// no exception if it pass i do not need any more capture
				
				if(result.getThrowable() !=null) {
					test.log(status, result.getThrowable());
				}else {
					test.log(status, "Test " + status.toString().toLowerCase()+ "ed");
				}
				
				extent.endTest(test);
			}
		}
	}
	
	private Date getTime(long millis) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	
	
	
	

}
