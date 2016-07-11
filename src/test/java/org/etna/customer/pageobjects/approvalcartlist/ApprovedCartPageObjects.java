package org.etna.customer.pageobjects.approvalcartlist;
import java.util.List;

import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.allure.annotations.Step;

public class ApprovedCartPageObjects extends PageFactoryInitializer{
	
	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();

	@FindBy(id="ApproveCart")
	private WebElement approveCartButtonLocator;

	@FindAll(value={@FindBy(xpath="//table[contains(@class,'siteTable')]/descendant::li/descendant::a")})
	private List<WebElement> productNamesLocator;

	@FindBy(xpath="//span[text()='Reject Cart']/ancestor::a")
	private WebElement rejectCartButtonLocator;
	
	@FindBy(id="reasonid")
	private WebElement reasonTextboxLocator;
	
	@FindBy(id="popLoginBtn")
	private WebElement submitReasonButtonLocator;
	
	
	@FindBy(id="updateSelectedItems")
	private WebElement updateSelectedItemsButtonLocator;
	
	@Step("click on approve cart link")
	public ApprovedCartPageObjects clickOnApproveCart() {
		approveCartButtonLocator.click();
		return this;
	}

	public String getSpecificProductNameInShoppingCart() {
		
		return productNamesLocator.get(0).getText().trim();
	}

	public ApprovedCartPageObjects clickOnRejectCart() {
		rejectCartButtonLocator.click();
		return this;
	}
	
	public ApprovedCartPageObjects enterReason(String reason) {
		Waiting.explicitWaitVisibilityOfElement(reasonTextboxLocator, 3);
		reasonTextboxLocator.sendKeys(reason);
		return this;
	}

	public ApprovedCartPageObjects clickOnSubmit() {
		submitReasonButtonLocator.click();
		return this;
	}

	public ApprovedCartPageObjects clickOnUpdateSelectedItems() {
		Waiting.explicitWaitVisibilityOfElement(updateSelectedItemsButtonLocator, 5);
		updateSelectedItemsButtonLocator.click();
		return this;
	}
	
	
}