package org.etna.customer.pageobjects.homepage;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class PlumbingDivisionPageObjects extends PageFactoryInitializer {
	
	
	 SearchDataPropertyFile data = new SearchDataPropertyFile();
	 ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	 
	 @FindBy(xpath="//h2")
	 private WebElement pageNameLocator;
	 
	 @FindBy(xpath="//div[contains(@class,'column col-sm-6-clsstmp col-xs-6-clsstmp col-md-9')]/descendant::p")
	 private WebElement contentLocator;
	 
	public PlumbingDivisionPageObjects verifyPlumbingPage(String plumbingPageBreadcrumb, String plumbingPageContent) {
		Assert.assertEquals(pageNameLocator.getText().trim(), plumbingPageBreadcrumb.toUpperCase());
		
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim()
				.equals(plumbingPageBreadcrumb),
				"Breadcrumb is not "+plumbingPageBreadcrumb+". It is  "+productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim());
		
		Assert.assertEquals(contentLocator.getText().replace("\n", "").trim(),plumbingPageContent);
		return this;
	}

}
	
