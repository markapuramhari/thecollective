package org.etna.customer.pageobjects.sharepopup;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.SearchDataPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class SharePopUpPageObjects extends PageFactoryInitializer {
	
	public SearchDataPropertyFile data = new SearchDataPropertyFile();
	
	@FindBy(xpath="//div[contains(@class,'popupHeader')]/h3")
	private WebElement shareCartHeadingLocator;
	
	@FindBy(id="popkeyword")
	private WebElement keywordLocator;
	
	@FindBy(id="popLoginBtn")
	private WebElement searchButtonLocator;
	
	@FindBy(xpath="//form[@id='popShareForm']/p")
	private WebElement instructionsButtonLocator;
	
	@FindBy(xpath="//div[contains(@id,'sharePopDiv1')]/descendant::a[@class='closeBtn']")
	private WebElement closeButtonLocator;
	
	@FindBy(xpath="//div[@id='pLoginErr1']/span")
	private WebElement errorMsgLocator;
	
	@FindBy(xpath="//input[@value='Reset']")
	private WebElement resetButtonLocator;
	
	@FindBy(xpath="//input[@value='Share']")
	private WebElement shareButtonLocator;
	
	@FindBy(xpath="//div[@id='innerContent']")
	private WebElement userNotFoundLocator;
	
	@FindBy(xpath="//div[@id='innerContent']/descendant::a[@class='closeBtn']")
	private WebElement closeButtonUserNotFoundLocator;
	
	
	
	
	@Step("verify Share pop up page")
	public SharePopUpPageObjects verifySharePopUp(String sharePopUpHeading,String shareInstructions) {
		
		Assert.assertTrue(keywordLocator.isDisplayed(),"keyword text box is not displayed.");
		Assert.assertTrue(searchButtonLocator.isDisplayed(),"Search Button is not displayed.");
		Assert.assertEquals(shareCartHeadingLocator.getText().trim(),sharePopUpHeading,"Share Pop Up heading is not displayed.");
		Assert.assertEquals(instructionsButtonLocator.getText().trim(), shareInstructions);
		Assert.assertTrue(closeButtonLocator.isDisplayed(),"Close Button is not displayed.");
		return this;
	}
	
	public SharePopUpPageObjects clickOnCloseButton() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",closeButtonLocator);
		return this;
	}
	
	public SharePopUpPageObjects clickOnSearchButton() {
		searchButtonLocator.click();
		return this;
	}
	
	public SharePopUpPageObjects verifyErrorMsg(String errorMsg) {
		Assert.assertEquals(errorMsgLocator.getText().trim(), errorMsg);
		return this;
	}

	public SharePopUpPageObjects enterKeyword(String validKeywordForShareCart) {
		keywordLocator.sendKeys(validKeywordForShareCart);
		return this;
	}

	public SharePopUpPageObjects verifySearchResult(String validKeywordForShareCart) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'"+validKeywordForShareCart+"')]")).isDisplayed(),"Search result is not getting displayed");
		return this;
	}

	public SharePopUpPageObjects clickOnTheSpecificCheckbox(String validKeywordForShareCart,int numberOfCheckboxesToClick) throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> chboxes = driver.findElements(By.xpath("//td[contains(text(),'"+validKeywordForShareCart+"')]/following-sibling::td/descendant::label"));
		for(int i = 0 ; i < numberOfCheckboxesToClick; i++)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",chboxes.get(i));
		}
		return this;
	}

	public SharePopUpPageObjects verifyWhetherCheckboxesAreClicked() {
		Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return $('#sharedUserIdCheck').attr('checked');"), "checked","checkboxes are not checked");
		return this;
	}

	public SharePopUpPageObjects clickOnResetButton() {
		resetButtonLocator.click();
		return this;
		
	}

	public SharePopUpPageObjects verifyWhetherCheckboxesAreNotClicked() throws InterruptedException {
		Thread.sleep(1700);
		Assert.assertEquals(((JavascriptExecutor) driver).executeScript("return $('#sharedUserIdCheck').attr('checked');"), null,"checkboxes are still checked");
		return this;
	}

	public SharePopUpPageObjects clickOnShareButton() {
		Waiting.explicitWaitVisibilityOfElement(shareButtonLocator, 5);
		shareButtonLocator.click();
		return this;
	}

	public SharePopUpPageObjects verifyNoSearchResults(String noSearchResultsMessage) {
		Waiting.explicitWaitVisibilityOfElement(userNotFoundLocator, 5);
		Assert.assertEquals(userNotFoundLocator.getText().trim(), noSearchResultsMessage,"User not found message is not displayed.");
		return this;
	}

	public SharePopUpPageObjects clickOnCloseButtonForUserNotFound() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",closeButtonUserNotFoundLocator);
		
		return this;
	}
}
