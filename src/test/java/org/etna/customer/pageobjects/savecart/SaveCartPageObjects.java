package org.etna.customer.pageobjects.savecart;
import java.util.List;

import org.etna.customer.pageobjects.productgroups.MyProductGroupsPageObjects;
import org.etna.maincontroller.MainController;
import org.etna.maincontroller.PageFactoryInitializer;
import org.etna.utils.ApplicationSetUpPropertyFile;
import org.etna.utils.TestUtility;
import org.etna.utils.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import ru.yandex.qatools.allure.annotations.Step;

public class SaveCartPageObjects extends PageFactoryInitializer{

	ApplicationSetUpPropertyFile setUp = new ApplicationSetUpPropertyFile();
	
	@FindBy(xpath="//h2")
	private WebElement pageName;
	
	@FindBy(xpath="//button[@id='groupNameSaveBtn']")
	private WebElement deleteSaveCartButton;
	
	@FindBy(xpath="//dl[@id='bulkOptions']/dt/a")
	private WebElement bulkOptionsCLickLocator;
	
	@FindAll({@FindBy(xpath="//dl[@id='bulkOptions']/dd/descendant::li/descendant::span")})
	private List<WebElement> bulkOptionsValuesLocator;

	@Step("click on cart name : {0} ")
	public SaveCartPageObjects clickOnTheCreatedSaveCart(String saveCartName) {
		
	driver.findElement(By.xpath("//a[contains(text(),'"+saveCartName+"')]")).click();
	return this;
	}
	
	@Step("verify breadcrumb is {0} ")
	public SaveCartPageObjects verifyBreadCrumps(String saveCartBreadcrump) {
		Waiting.explicitWaitVisibilityOfElements(productDetailsPage().breadCrumps, 10);
		Assert.assertTrue(productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim().equalsIgnoreCase(saveCartBreadcrump.trim()),"Breadcrump is not "+saveCartBreadcrump+". It is :"+productDetailsPage().breadCrumps.get(productDetailsPage().breadCrumps.size()-1).getText().replace("/", "").trim());
		return this;
	}
	
	@Step("verify page name  is {0} ")
	public SaveCartPageObjects verifyPageName(String saveCartBreadcrump) {
		Assert.assertTrue(pageName.getText().equalsIgnoreCase(saveCartBreadcrump),"Breadcrump is not "+saveCartBreadcrump);
		return this;
	}
	
	@Step("verify cart title contains saved groups ")
	public SaveCartPageObjects verifySaveCartTitle() throws Exception {
		Assert.assertEquals(driver.getTitle().trim(),"Saved Groups" +" | "+setUp.getProductName().trim());
		return this;
	}

	@Step("click on delete save cart ")
	public SaveCartPageObjects deleteSaveCart() {
		Waiting.explicitWaitVisibilityOfElement(deleteSaveCartButton, 15);
		deleteSaveCartButton.click();
		return this;
	}

	@Step("verify deletion of save cart is {0} ")
	public SaveCartPageObjects verifyDeletionOfSaveCart(String saveCartName)
	{
		Assert.assertTrue(assertDeletionOfSaveCart(saveCartName),"Cart is not deleted yet.");
		return this;
	}
	public boolean  assertDeletionOfSaveCart(String saveCartName) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try
		{
		Assert.assertFalse(driver.findElement(By.xpath("//a[contains(text(),'"+saveCartName+"')])")).isDisplayed());
		}
		catch(Exception e)
		{
			return true;
		}
		return false;
	}

	@Step("verify title is {0} ")
	public SaveCartPageObjects verifyTitleAfterClickingOnTheCartCreated() throws Exception {
		Assert.assertEquals(driver.getTitle().trim(),"Saved Cart" +" | "+setUp.getProductName().trim());
		return this;
	}
	
	@Step("select {0} from bulk actions dropdown")
	public SaveCartPageObjects selectBulkActionsDropdown(String bulkOption) throws Exception {
		bulkOptionsCLickLocator.click();
		switch(bulkOption)
		{
		case "Delete Selected Items":
			driver.findElement(By.xpath("//ul[@id='bulkActionClick']/descendant::span[text()='Delete Selected Items']")).click();
			break;
		case "Update Selected Items":
			driver.findElement(By.xpath("//ul[@id='bulkActionClick']/descendant::span[text()='Update Selected Items']")).click();
			break;
		case "Add Selected Items to Cart":
			driver.findElement(By.xpath("//ul[@id='bulkActionClick']/descendant::span[text()='Add Selected Items to Cart']")).click();
			break;
		default: throw new Exception("invalid input");	
		}
		return this;
	}
	
	@Step("verify whether alert text is {0}")
	public SaveCartPageObjects verifyAlertText(String expectedAlertText) throws Exception{
		Thread.sleep(1500);
		Assert.assertTrue(assertAlertText(expectedAlertText),"Alert text is invalid");
		return this;
		
	}
	
	public boolean assertAlertText(String expectedAlertText) throws Exception
	{
		boolean t = TestUtility.getAlertText().trim().equals(expectedAlertText);
		TestUtility.alertAccept();
		return t;
	}

}
