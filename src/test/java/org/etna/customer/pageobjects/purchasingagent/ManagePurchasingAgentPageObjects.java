package org.etna.customer.pageobjects.purchasingagent;
import java.util.List;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;


public class ManagePurchasingAgentPageObjects extends PageFactoryInitializer{
	
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchTextboxLocator;

	@FindBy(xpath="//td[contains(text(),'No matching records found')]")
	private WebElement noMatchingRecordsFoundLocator;
	
	@FindAll(value={@FindBy(xpath="//a[@class='button' and contains(text(),'Disable')]")})
	private List<WebElement> disableButtonLocators;
	
	@Step("search for email id {0}")
	public ManagePurchasingAgentPageObjects searchForTheEmailId(String email) {
		Waiting.explicitWaitVisibilityOfElement(searchTextboxLocator, 10);
		searchTextboxLocator.clear();
		searchTextboxLocator.sendKeys(email);
		return this;
		
	}

	@Step("click on disable for the respective {0}")
	public ManagePurchasingAgentPageObjects clickOnSpecificDisableButton(String email) throws Exception{
	Thread.sleep(1500);
	driver.findElement(By.xpath("//td[contains(text(),'"+email+"')]/following-sibling::td/descendant::a[contains(@onclick,'disableUser')]")).click();;
	
	return this;
	}
	
	public boolean assertDisableOfUser(String email) {
		try
		{
			
		if(noMatchingRecordsFoundLocator.isDisplayed())
		{
			return true;
		}
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		return false;
		
	} 

	@Step("verify no match records is displayed.")
	public ManagePurchasingAgentPageObjects verifyDisableOfUser(String email) {
		Assert.assertTrue(assertDisableOfUser(email),"No Match Records Found is not displayed.");
		return this;
	}

	@Step("click on {0} st/nd/rd disable button")
	public ManagePurchasingAgentPageObjects clickOnSpecificDisableButton(int specificButton) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",disableButtonLocators.get(specificButton-1));
		return this;
	}

	public String getSpecficEmailId(int specificEmailId) {
		return	driver.findElement(By.xpath("//table[@id='ManagePurchaseAgent']/descendant::a[@class='button' and contains(text(),'Disable')]["+specificEmailId+"]/ancestor::td/preceding-sibling::td[3]")).getText().trim();
	}

	@Step("verify whether email id : {0} is displayed.")
	public ManagePurchasingAgentPageObjects verifyDisplayOfEmailId(String emailId) {
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+emailId+"')]")).isDisplayed(),"Cancellation of alert message while disable a user in manage purchasing agent is not working.");
		return this;
	} 

	
	
}