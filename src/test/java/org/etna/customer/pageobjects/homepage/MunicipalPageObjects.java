package org.etna.customer.pageobjects.homepage;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class MunicipalPageObjects extends PageFactoryInitializer {
	
	
	 SearchDataPropertyFile data = new SearchDataPropertyFile();
	 ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	 
	 @FindBy(xpath="//h2")
	 private WebElement pageNameLocator;
	 
	 @FindBy(xpath="//div[@class='column col-sm-6-clsstmp col-xs-6-clsstmp col-md-12']")
	 private WebElement contentLocator;
	 


	public MunicipalPageObjects verifyMunicipalPage(String municipalBreadcrumb, String municipalContent) {
		
		Waiting.explicitWaitVisibilityOfElement(pageNameLocator, 5);
		
		Assert.assertEquals(pageNameLocator.getText().trim(), municipalBreadcrumb.toUpperCase());

		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim()
				.equals(municipalBreadcrumb),
				"Breadcrumb is not "+municipalBreadcrumb+". It is  "+productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim());
		Assert.assertEquals(contentLocator.getText().replace("\n", "").trim(),municipalContent);
		return this;
	}


}
	
