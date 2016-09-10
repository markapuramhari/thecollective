package org.etna.customer.pageobjects.productgroups;
import java.util.List;

import org.etna.customer.pageobjects.orderconfirmation.OrderConfirmationPageObjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class MyProductGroupPopUp extends PageFactoryInitializer{

	@FindBy(id="newProductGroupName")
	private WebElement productGroupTextboxLocator;
	
	@FindBy(xpath="//input[@value='Add New Group']")
	private WebElement addNewGroupLocator;
	
	@FindBy(xpath="//a[text()='Add']")
	private WebElement addButtonLocator;
	
	
	@FindBy(xpath="//li[@class='hintCorrect']")
	private WebElement successMessageLocator;
	
	
	

	public MyProductGroupPopUp enterProductGroupName(String productGroupName) {
		Waiting.explicitWaitVisibilityOfElement(productGroupTextboxLocator, 3);
		productGroupTextboxLocator.clear();
		productGroupTextboxLocator.sendKeys(productGroupName);
		return this;
	}



	public MyProductGroupPopUp clickOnAddNewGroup() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",addNewGroupLocator);
		return this;
	}
	
	public MyProductGroupPopUp clickOnAddButton() {
		addButtonLocator.click();
		return this;
	}
	
	
	public MyProductGroupPopUp verifySuccessMsg() {
		Waiting.explicitWaitVisibilityOfElement(successMessageLocator, 5);
		Assert.assertTrue(successMessageLocator.isDisplayed());
		return this;
	}



	public MyProductGroupPopUp clickOnTheCreatedProductGroup(String myProductGroupName) {
		driver.findElement(By.xpath("//a[text()='"+myProductGroupName+"']")).click();
		return this;
	}



	public MyProductGroupPopUp clickOnTheGroupCreatedInTheList(String myProductGroupName) throws InterruptedException {
		Thread.sleep(2000);
		try
		{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//label[text()='"+myProductGroupName+"']")));
		}
		catch(NoSuchElementException e)
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[text()='"+myProductGroupName+"']")));
			
		}
		return this;
	}



	public MyProductGroupPopUp verifyCheckboxAssociatedWithTheProductGroupIsSelected() {
			
		return this;
	}
	
	
	

}
