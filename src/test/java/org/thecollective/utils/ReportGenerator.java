package org.thecollective.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;
import org.thecollective.maincontroller.MainController;
import org.zeroturnaround.zip.ZipUtil;

public class ReportGenerator implements IReporter {
	private static int passedtest;
	private static int failedtest;
	private static int skippedtest;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		 String outputReport = "./Report";
		try {
			FileUtils.forceMkdir(new File(outputReport));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}		
		outputReport += "/Report_" + SendEmailGmail.getDate()+"_" + SendEmailGmail.getTime();
		
			if(System.getProperty("os.name").toUpperCase().contains("MAC"))
				
			{
		String mvnSiteCommand;
		try {
			mvnSiteCommand = PropertyFileReader.propertiesReader(MainController.applicationSetUp, "mvnSiteCommand");
		
		Runtime.getRuntime().exec("open /bin/bash "+mvnSiteCommand); 
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
			}
		
		else if (System.getProperty("os.name").toUpperCase().contains("WIN"))
		{
			try
			{
			String mvnSiteCommand = PropertyFileReader.propertiesReader(MainController.applicationSetUp, "mvnSiteCommand");
			File file = new File(mvnSiteCommand);
			Runtime.getRuntime().exec("cmd /c start "+file.getAbsolutePath());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(70000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}		
		for (ISuite suite : suites) {
			
	        Map<String, ISuiteResult> result = suite.getResults();

	        for (ISuiteResult r : result.values()) {
	            ITestContext context = r.getTestContext();
	            
	            passedtest = context.getPassedTests().size();
	           
	            failedtest = context.getFailedTests().size();
	           
	            skippedtest = context.getSkippedTests().size();
	 
	        }
	        
	 File zipFile = new File((outputReport+".zip"));
	 ZipUtil.pack(new File("./target/site/"),zipFile);
			   
	    
	    try {
			if(PropertyFileReader.propertiesReader(MainController.applicationSetUp, "sendEmailPermission").equalsIgnoreCase("yes"))
			{
				SendEmailOutLook.sendemail(passedtest, failedtest, skippedtest,zipFile);
			}
		} 
	    catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	}
}