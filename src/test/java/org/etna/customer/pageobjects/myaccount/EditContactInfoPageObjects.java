package org.etna.customer.pageobjects.myaccount;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

/*
 * @author Hemanth.Sridhar
 */

public class EditContactInfoPageObjects extends PageFactoryInitializer {
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	Actions action = new Actions(driver);
	
	@FindBy(xpath="//h2")
	private WebElement editContactInfoPageName;
	
	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	
	
	@FindBy(id="address1")
	private WebElement address1;
	
	
	
	@FindBy(id="address2")
	private WebElement address2;
	
	
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement city;
	
	
	
	@FindBy(id="countrySelectShip")
	private WebElement country;
	
	
	
	@FindBy(id="stateSelectShip")
	private WebElement state;
	
	
	
	@FindBy(id="zip")
	private WebElement zip;
	
	
	
	@FindBy(id="billPhone")
	private WebElement phoneNumber;
	
	
	@FindBy(id="email")
	private WebElement email;	
	
	
	@FindBy(xpath="//span[contains(text(),'Use Entity Address')]")
	private WebElement useEntityAddress;
	
	@FindBy(id="updateBtn")
	private WebElement updateButton;
	
	@Step("verify edit contact info page title contains {0}")
	public EditContactInfoPageObjects verifyEditContactInfoPageTitle(String editContactInfoPageName) {
		Assert.assertEquals(driver.getTitle().trim(), editContactInfoPageName);
		return this;
	}
	
	@Step("verify edit contact info page name contains {0}")
	public EditContactInfoPageObjects verifyEditContactInfoPageName(String editContactInfoPageName) {
		Assert.assertEquals(editContactInfoPageName.trim().toUpperCase(), editContactInfoPageName.toUpperCase());
		return this;
	}
	
	@Step("verify edit contact info breadcrumb contains {0}")
	public EditContactInfoPageObjects verifyEditContactInfoBreadcrumb(String editContactInfoPageName) {
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().
				breadCrumps.size()-1).getText().replace("/", "").trim()
				.equalsIgnoreCase(editContactInfoPageName),"Breadcrump is not "+editContactInfoPageName+". It is "+productDetailsPage()
				.breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim()+".");
		return this;
	}

	@Step("verify entity address checkbox")
	public EditContactInfoPageObjects verifyEntityAddressCheckbox() {
		Assert.assertTrue(useEntityAddress.isDisplayed(),"Use entity checkbox is not displayed.");
		return this;
	}

	@Step("verify update button")
	public EditContactInfoPageObjects verifyUpdateButton() {
		Assert.assertTrue(updateButton.isDisplayed(),"Update button is not displayed");
		return this;
	}

	public String getFirstName() {
		
		return firstName.getAttribute("value").trim();
	}

	public String getLastName() {
		
		return lastName.getAttribute("value").trim();
	}

	public String getPhoneNumber() {

		return phoneNumber.getAttribute("value").trim();
	}

	public String getEmailAddress() {

		return email.getAttribute("value").trim();
	}

	
	public String[] getContactDetails() {
		String[] str = {getFirstName(),getLastName(),getPhoneNumber(),getEmailAddress()};
		return str;
	}
}
	
	
