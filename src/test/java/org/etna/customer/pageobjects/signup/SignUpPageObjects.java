package org.etna.customer.pageobjects.signup;
import java.util.List;

import org.etna.customer.pageobjects.signup.firsttimeordering.FirstTimeOrderingRegistrationPageObjects;
import org.etna.customer.pageobjects.signup.newcommercialcustomer.CommercialCustomerRegistrationPageObjects;
import org.etna.customer.pageobjects.signup.retailuser.RetailCustomerRegistrationPageObjects;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class SignUpPageObjects extends PageFactoryInitializer{

	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	//mks 
	/*@FindBy(xpath="//h4[contains(text(),'New Retail Customer')]")
	private WebElement newRetailCustomerTabLocator;
	
	@FindBy(xpath="//h4[contains(text(),'New Commercial Customer')]")
	private WebElement newCommercialCustomerTabLocator;

	@FindBy(xpath="//h4[contains(text(),'First Time Ordering')]")
	private WebElement firstTimeOrderingTabLocator;*/
	
	//etna
	@FindBy(xpath="//a[contains(@href,'newRetailCustomer')]")
	private WebElement newRetailCustomerTabLocator;
	
	@FindBy(xpath="//a[contains(@href,'newCommertialCustomer')]")
	private WebElement newCommercialCustomerTabLocator;

	@FindBy(xpath="//a[contains(@href,'firstTimeOrder')]")
	private WebElement firstTimeOrderingTabLocator;
	
	@FindAll(value={@FindBy(xpath="//ul[@class='cimm_breadcrumbs']/li")})
	private List<WebElement> breadCrumpsLocator;
	
	@FindBy(className="cimm_pageTitle")
	private WebElement registrationPageNameLocator;
	
	@Step("click on new retail customer tab")
	public RetailCustomerRegistrationPageObjects clickNewRetailCustomerTab() {
		Waiting.explicitWaitVisibilityOfElement(newRetailCustomerTabLocator, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",newRetailCustomerTabLocator);
		return new RetailCustomerRegistrationPageObjects();
	}

	@Step("click on new commercial customer tab")
	public CommercialCustomerRegistrationPageObjects clickNewCommercialCustomerTab() {
		Waiting.explicitWaitVisibilityOfElement(newCommercialCustomerTabLocator, 10);
		newCommercialCustomerTabLocator.click();
		return new CommercialCustomerRegistrationPageObjects();
	}

	@Step("click on first time ordering tab")
	public FirstTimeOrderingRegistrationPageObjects clickFirstTimeOrderingTab() {
		Waiting.explicitWaitVisibilityOfElement(firstTimeOrderingTabLocator, 10);
		firstTimeOrderingTabLocator.click();
		return new FirstTimeOrderingRegistrationPageObjects();
	}

	
	@Step("verify registration breadcrump is {0}")
	public SignUpPageObjects verifyBreadCrump(String registrationBreadCrump)
	{
	Assert.assertEquals(breadCrumpsLocator.get(breadCrumpsLocator.size()-1).getText().replace("/", "").trim(),registrationBreadCrump);
	return this;
}

	@Step("verify registration page name is {0}")
	public SignUpPageObjects verifyRegistrationPageName(String registrationBreadCrump) {
		Assert.assertEquals(registrationPageNameLocator.getText().trim().toLowerCase(), registrationBreadCrump.toLowerCase(),"Getting "+registrationPageNameLocator.getText().trim()+" But expecting "+registrationBreadCrump+".");
		return this;
	}

	@Step("verify whether first time order is enabled when we land on sign up page ")
	public SignUpPageObjects verifyWhetherFirstTimeOrderingIsEnabledFirst() {
		Assert.assertTrue(firstTimeOrderingTabLocator.getAttribute("class").equals("active"), "First Time Ordering tab is not enabled first.");
		return this;
	}

	@Step("verify whether new commercial customer and new retail customer is disabled first.")
	public SignUpPageObjects verifyWhetherNewCommercialCustomerIsEnabledFirstAndNewRetailCustomerIsNotEnabledFirst() {
	
		Assert.assertTrue(newCommercialCustomerTabLocator.getAttribute("class").equals("active"), "New Commercial customer tab is not enabled first.Getting "+newCommercialCustomerTabLocator.getAttribute("class"));
		Assert.assertTrue(newRetailCustomerTabLocator.getAttribute("class").equals(""), "New Commercial customer tab is not enabled first.");
		return this;
	}

}