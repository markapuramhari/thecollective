package org.etna.customer.pageobjects.purchasingagent;
import java.util.List;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;


public class DisablePurchasingAgentPageObjects extends PageFactoryInitializer{
	
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindAll(value={@FindBy(xpath="//a[@class='button' and contains(text(),'Disable')]")})
	private List<WebElement> disableButtonLocators;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTextboxLocator;
	
	@FindBy(xpath="//h2")
	private WebElement pageNameLocator;
	
	@FindBy(xpath="//ul/descendant::li[contains(text(),'Disable Purchasing Agent')]")
	private WebElement disablePurchaseAgentBreadcrumbLocator;
	
	public String getSpecficEmailId(int specificEmailId) {
		return	driver.findElement(By.xpath("//table/tbody/tr["+specificEmailId+"]/descendant::td[3]")).getText().trim();
	}
	
	@Step("click on {0} st/nd/rd disable button")
	public DisablePurchasingAgentPageObjects clickOnSpecificDisableButton(int specificButton) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",disableButtonLocators.get(specificButton-1));
		return this;
	}

	@Step("verify email id : {0} is displayed ")
	public DisablePurchasingAgentPageObjects verifyDisplayOfEmailId(String emailId) {
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+emailId+"')]")).isDisplayed(),"Cancellation of alert message while disable a user in manage purchasing agent is not working.");
		return this;
	}

	@Step("verify disable purchase agent page")
	public DisablePurchasingAgentPageObjects verifyDisablePurchaseAgentPage() {
		Waiting.explicitWaitVisibilityOfElement(disablePurchaseAgentBreadcrumbLocator, 10);
		Assert.assertTrue(disablePurchaseAgentBreadcrumbLocator.isDisplayed(),"Disable purchase agent breadcrump is not displayed.");
		Assert.assertTrue(pageNameLocator.getText().trim().equalsIgnoreCase("Disable Purchasing Agent"),"Disable purchase agent page name is wrong. getting "+pageNameLocator.getText().trim()+" as the page name.");
		return this;
	}

	@Step("search for email id {0}")
	public DisablePurchasingAgentPageObjects searchForTheEmailId(String email) {
		Waiting.explicitWaitVisibilityOfElement(searchTextboxLocator, 10);
		searchTextboxLocator.clear();
		searchTextboxLocator.sendKeys(email);
		return this;
		
	}


	@Step("click on disable for the respective {0}")
	public DisablePurchasingAgentPageObjects clickOnSpecificDisableButton(String email) throws Exception {
		Thread.sleep(1500);
		driver.findElement(By.xpath("//td[contains(text(),'"+email+"')]/following-sibling::td/descendant::a[contains(@onclick,'disableAuthorization')]")).click();;
		
		return this;
		}
	}
