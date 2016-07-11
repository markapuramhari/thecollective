package org.etna.utils;

import org.etna.maincontroller.MainController;

public class ApplicationSetUpPropertyFile extends MainController{

	
	public String getURL() throws Exception{
		String url = PropertyFileReader.propertiesReader(applicationSetUp, "url");
		return url;
		
	}
	
	
	public String getBrowser() throws Exception{
		String browser = PropertyFileReader.propertiesReader(applicationSetUp, "browser");
		return browser;
		
	}
	
	public String getProductName() throws Exception{
		String productName = PropertyFileReader.propertiesReader(applicationSetUp, "productName");
		return productName;
	}
	
	
	public String getVideoPermission() throws Exception{
		String videoPermisson = PropertyFileReader.propertiesReader(applicationSetUp, "videoPermisson");
		return videoPermisson;
	}
	
	public String getTypeOfTestForReport() throws Exception{
		String typeOfTestForReport = PropertyFileReader.propertiesReader(applicationSetUp, "typeOfTestForReport");
		return typeOfTestForReport;
	}
	
	public String getFrom() throws Exception{
		String from = PropertyFileReader.propertiesReader(applicationSetUp, "from");
		return from;
	}
	
	public String getUsername() throws Exception{
		String getUsername = PropertyFileReader.propertiesReader(applicationSetUp, "getUsername");
		return getUsername;
	}
	
	public String getPassword() throws Exception{
		String password = PropertyFileReader.propertiesReader(applicationSetUp, "password");
		return password;
	}
	
	public String getBcc() throws Exception{
		String bcc = PropertyFileReader.propertiesReader(applicationSetUp, "bcc");
		return bcc;
	}
	
	public String getcc() throws Exception{
		String cc = PropertyFileReader.propertiesReader(applicationSetUp, "cc");
		return cc;
	}
	
	public String getTo() throws Exception{
		String to = PropertyFileReader.propertiesReader(applicationSetUp, "to");
		return to;
	}
	
	public String getSendEmailPermisson() throws Exception{
		String sendEmailPermission = PropertyFileReader.propertiesReader(applicationSetUp, "sendEmailPermission");
		return sendEmailPermission;
	}
	
}
