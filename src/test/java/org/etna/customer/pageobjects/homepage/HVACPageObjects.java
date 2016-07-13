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
public class HVACPageObjects extends PageFactoryInitializer {
	
	
	 SearchDataPropertyFile data = new SearchDataPropertyFile();
	 ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	 
	 @FindBy(xpath="//h2")
	 private WebElement pageNameLocator;
	 
	 @FindBy(xpath="//div[@class='column col-md-12 col-sm-12-clsstmp col-xs-12-clsstmp']")
	 private WebElement contentLocator;
	 
	 public HVACPageObjects verifyHVACPage(String hvacBreadcrumb, String hvacContent) {
		Waiting.explicitWaitVisibilityOfElement(pageNameLocator, 5);
		System.out.println(contentLocator.getText().replace("\n", "").trim());
		Assert.assertEquals(pageNameLocator.getText().trim(), hvacBreadcrumb.toUpperCase());

		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim()
				.equals(hvacBreadcrumb),
				"Breadcrumb is not "+hvacBreadcrumb+". It is  "+productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim());
		
		Assert.assertEquals(contentLocator.getText().replace("\n", "").trim(),hvacContent);
		return this;
	 }



}
	
